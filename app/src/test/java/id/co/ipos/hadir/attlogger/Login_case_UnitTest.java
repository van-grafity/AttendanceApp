package id.co.ipos.hadir.attlogger;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import id.co.ipos.hadir.attlogger.Infrastruktur.Db.CompanyRepository;
import id.co.ipos.hadir.attlogger.Infrastruktur.Net.IposAuth;
import id.co.ipos.hadir.attlogger.Infrastruktur.Net.Token;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenterImpl;
import id.co.ipos.hadir.attlogger.View.AttendanceView;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Login_case_UnitTest {

    @InjectMocks
    private AttendancePresenterImpl m_presenter;
    @Mock
    private AttendanceView m_attendanceView;
    @Mock
    private TokenStore m_tokenStore;
    @Mock
    private IposAuth m_iposAuth;
    @Mock
    private CompanyRepository m_companyRepository;
    @Spy
    private Scheduler processScheduler;
    @Spy
    private Scheduler androidScheduler;

    private Scheduler testScheduler=new TestScheduler();


    @Before
    public void initMock(){
        processScheduler=testScheduler;
        androidScheduler=testScheduler;
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_main_success() {
        doReturn(Observable.just(new Token())).when(m_iposAuth).getToken("user", "123");
        when(m_attendanceView.getUsername()).thenReturn("user");
        when(m_attendanceView.getPassword()).thenReturn("123");
        when(m_companyRepository.isCompanyExist()).thenReturn(true);
        m_presenter.login();
        ((TestScheduler)testScheduler).triggerActions();
        verify(m_tokenStore, times(1)).saveToken(isA(Token.class));
        verify(m_attendanceView, times(1)).showReadyState();
    }

    @Test
    public void test_jika_token_tidak_didapat() {
        String error="username atau password salah";
        doReturn(Observable.error(new UserAuthenticationException(error))).when(m_iposAuth).getToken("user", "123");
        when(m_attendanceView.getUsername()).thenReturn("user");
        when(m_attendanceView.getPassword()).thenReturn("123");
        m_presenter.login();
        ((TestScheduler)testScheduler).triggerActions();
        verify(m_attendanceView, times(1)).showDisplayError(error);
    }

    @Test
    public void cek_data_company_ada(){
        when(m_attendanceView.getUsername()).thenReturn("user");
        when(m_attendanceView.getPassword()).thenReturn("123");
        doReturn(Observable.just(new Token())).when(m_iposAuth).getToken("user", "123");
        when(m_companyRepository.isCompanyExist()).thenReturn(true);
        m_presenter.login();
        ((TestScheduler)testScheduler).triggerActions();
        verify(m_tokenStore, times(1)).saveToken(isA(Token.class));
        verify(m_attendanceView, times(1)).showReadyState();
    }

    @Test
    public void cek_data_company_tidak_ada(){
        when(m_attendanceView.getUsername()).thenReturn("user");
        when(m_attendanceView.getPassword()).thenReturn("123");
        doReturn(Observable.just(new Token())).when(m_iposAuth).getToken("user", "123");
        when(m_companyRepository.isCompanyExist()).thenReturn(false);
        m_presenter.login();
        ((TestScheduler)testScheduler).triggerActions();
        verify(m_attendanceView, times(1)).downloadData();
    }

    private class UserAuthenticationException extends Throwable  {
        public UserAuthenticationException(String error) {
            super(error);
        }
    }
}
