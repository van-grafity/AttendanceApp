package id.co.ipos.hadir.attlogger.Presenter;

import android.content.Context;

import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.View.AttendanceView;

public class AttendancePresenterImpl implements AttendancePresenter {
    private AttendanceView attendanceView;
    private TokenStore tokenStore;
    private Context context;

    public AttendancePresenterImpl(AttendanceView attendanceView, TokenStore tokenStore) {
        this.attendanceView = attendanceView;
        this.tokenStore = tokenStore;
    }

    @Override
    public void prepare() {
        if (this.tokenStore.isTokenExist() && !this.tokenStore.isTokenExpired()) {
            this.attendanceView.showReadyState();
        }
        else {
            this.attendanceView.showLoginState();
        }


    }
}
