package id.co.ipos.hadir.attlogger;

import android.security.keystore.UserNotAuthenticatedException;

import org.junit.Before;
import org.junit.Test;

import id.co.ipos.hadir.attlogger.Infrastruktur.Db.CompanyRepository;
import id.co.ipos.hadir.attlogger.Infrastruktur.Net.IposAuth;
import id.co.ipos.hadir.attlogger.Infrastruktur.Net.Token;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenter;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenterImpl;
import id.co.ipos.hadir.attlogger.View.AttendanceView;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Login_case_UnitTest {
    private AttendanceView m_attendanceView;
    private AttendancePresenter m_presenter;
    private TokenStore m_tokenStore;
    private IposAuth m_iposAuth;
    private CompanyRepository m_companyRepository;
    public Scheduler testScheduler;


    @Before
    public void initMock(){
        m_attendanceView = mock(AttendanceView.class);
        m_presenter = mock(AttendancePresenter.class);
        m_tokenStore = mock(TokenStore.class);
        m_iposAuth = mock(IposAuth.class);
        m_companyRepository = mock(CompanyRepository.class);
        testScheduler = new TestScheduler();
        m_presenter = new AttendancePresenterImpl(m_attendanceView, m_tokenStore, m_iposAuth, m_companyRepository, testScheduler, testScheduler);
    }

    @Test
    public void test_main_success() {
        doReturn(Observable.just(new Token())).when(m_iposAuth).getToken("user", "123");
        when(m_attendanceView.getUsername()).thenReturn("user");
        when(m_attendanceView.getPassword()).thenReturn("123");
        when(m_companyRepository.isCompanyExist()).thenReturn(true);
        m_presenter.login();
        verify(m_tokenStore, times(1)).saveToken(isA(Token.class));
        verify(m_attendanceView, times(1)).showReadyState();
    }

    @Test
    public void test_jika_token_tidak_didapat() {
        doReturn(Observable.error(new UserNotAuthenticatedException("username atau password salah"))).when(m_iposAuth).getToken("user", "123");
        when(m_attendanceView.getUsername()).thenReturn("user");
        when(m_attendanceView.getPassword()).thenReturn("123");
        //when(m_iposAuth.getToken("user", "123")).thenReturn(null);
        m_presenter.login();
        verify(m_attendanceView, times(1)).showDisplayError();
    }

    @Test
    public void cek_data_company_ada(){
        when(m_attendanceView.getUsername()).thenReturn("user");
        when(m_attendanceView.getPassword()).thenReturn("123");
        doReturn(Observable.just(new Token())).when(m_iposAuth).getToken("user", "123");
        when(m_companyRepository.isCompanyExist()).thenReturn(true);
        m_presenter.login();
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
        verify(m_attendanceView, times(1)).downloadData();
    }

}
