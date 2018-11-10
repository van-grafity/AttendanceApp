package id.co.ipos.hadir.attlogger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenterImpl;
import id.co.ipos.hadir.attlogger.View.AttendanceView;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class Preparation_case_UnitTest {

    @Mock
    private TokenStore tokenStore;
    @Mock
    private AttendanceView m_attendanceView;

    @InjectMocks
    private AttendancePresenterImpl m_presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void test_main_success() {
        when(tokenStore.isTokenExist()).thenReturn(true);
        when(tokenStore.isTokenExpired()).thenReturn(false);
        m_presenter.prepare();
        verify(tokenStore, times(1)).isTokenExist();
        verify(tokenStore, times(1)).isTokenExpired();
        verify(m_attendanceView, times(1)).showReadyState();
    }

    @Test
    public void test_token_tidak_ada() {
        when(tokenStore.isTokenExist()).thenReturn(false);
        m_presenter.prepare();
        verify(m_attendanceView, times(1)).showLoginState();
        verify(m_attendanceView, times(0)).showReadyState();
    }

    @Test
    public void test_token_expired() {
        when(tokenStore.isTokenExist()).thenReturn(true);
        when(tokenStore.isTokenExpired()).thenReturn(true);
        m_presenter.prepare();
        verify(m_attendanceView, times(1)).showLoginState();
        verify(m_attendanceView, times(0)).showReadyState();
    }
}