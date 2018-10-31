package id.co.ipos.hadir.attlogger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenter;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenterImpl;
import id.co.ipos.hadir.attlogger.View.AttendanceView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class Preparation_case_UnitTest {

    @Mock
    private TokenStore m_tokenStore;
    @Mock
    private AttendanceView m_attendanceView;
    @Mock
    private AttendancePresenter m_presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        m_presenter = new AttendancePresenterImpl(m_attendanceView, m_tokenStore);
    }

    @Test
    public void test_main_success() {
        when(m_tokenStore.isTokenExist()).thenReturn(true);
        when(m_tokenStore.isTokenExpired()).thenReturn(false);
        m_presenter.prepare();
        verify(m_tokenStore, times(1)).isTokenExist();
        verify(m_tokenStore, times(1)).isTokenExpired();
        verify(m_attendanceView, times(1)).showReadyState();
    }

    @Test
    public void test_token_tidak_ada() {
        when(m_tokenStore.isTokenExist()).thenReturn(false);
        m_presenter.prepare();
        verify(m_attendanceView, times(1)).showLoginState();
        verify(m_attendanceView, times(0)).showReadyState();
    }

    @Test
    public void test_token_expired() {
        when(m_tokenStore.isTokenExist()).thenReturn(true);
        when(m_tokenStore.isTokenExpired()).thenReturn(true);
        m_presenter.prepare();
        verify(m_attendanceView, times(1)).showLoginState();
        verify(m_attendanceView, times(0)).showReadyState();
    }
}