package id.co.ipos.hadir.attlogger;

import org.junit.Before;
import org.junit.Test;

import id.co.ipos.hadir.attlogger.Model.Attendance;
import id.co.ipos.hadir.attlogger.Model.AttendanceImpl;
import id.co.ipos.hadir.attlogger.Model.AttendanceState;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenter;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenterImpl;
import id.co.ipos.hadir.attlogger.View.AttendanceView;
import id.co.ipos.hadir.attlogger.View.TokenStore;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class Preparation_case_UnitTest {

    @Test
    public void create_attendance_model() {
        Attendance attd = new AttendanceImpl();
        assertEquals(AttendanceState.Ready, attd.getState());
    }

    private TokenStore m_tokenStore;
    private AttendanceView m_attendanceView;
    private AttendancePresenter m_presenter;

    @Before
    public void setUp() {
        m_attendanceView = mock(AttendanceView.class);
        m_tokenStore = mock(TokenStore.class);
        m_presenter = new AttendancePresenterImpl(m_attendanceView, m_tokenStore);
    }

    @Test
    public void ketika_presenter_cek_token_ada_atau_tidak() {
        when(m_tokenStore.isTokenExist()).thenReturn(true);
        m_presenter.prepare();
        verify(m_tokenStore, times(1)).isTokenExist();
    }

    @Test
    public void ketika_presenter_cek_token_expired_atau_tidak() {
        when(m_tokenStore.isTokenExpired()).thenReturn(true);
        m_presenter.prepare();
        verify(m_tokenStore, times(1)).isTokenExist();
    }

    @Test
    public void ketika_presenter_show_ready_state() {
        when(m_attendanceView.showReadyState()).thenReturn(true);
        m_presenter.prepare();
        verify(m_attendanceView, times(1)).showReadyState();
    }

    @Test
    public void ketika_presenter_cek_token_tidak_ada() {
        when(m_tokenStore.isTokenExist()).thenReturn(false);
        m_presenter.prepare();
        verify(m_tokenStore, times(1)).isTokenExist();
        verify(m_attendanceView, times(1)).showReadyState();
    }
}