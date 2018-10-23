package id.co.ipos.hadir.attlogger.Presenter;

import id.co.ipos.hadir.attlogger.View.AttendanceView;
import id.co.ipos.hadir.attlogger.View.TokenStore;

public class AttendancePresenterImpl implements AttendancePresenter{
    private   AttendanceView attendanceView;
    private TokenStore tokenStore;

    public AttendancePresenterImpl(AttendanceView attendanceView, TokenStore tokenStore) {
        this.attendanceView = attendanceView;
        this.tokenStore = tokenStore;
    }

    @Override
    public void prepare() {
        this.tokenStore.isTokenExist();
        this.tokenStore.isTokenExpired();
        this.attendanceView.showReadyState();
    }
}
