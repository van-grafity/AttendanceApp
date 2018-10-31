package id.co.ipos.hadir.attlogger.Activity.Dagger;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenter;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenterImpl;
import id.co.ipos.hadir.attlogger.View.AttendanceView;
import id.co.ipos.hadir.attlogger.View.AttendanceViewImpl;

@Module
public class AttModule {
    @AttScope
    @Provides
    AttendancePresenter provideAttendancePresenter(AttendanceView attendanceView, TokenStore tokenStore){
        return new AttendancePresenterImpl(attendanceView, tokenStore);
    }
    @AttScope
    @Provides
    AttendanceView provideAttendanceView(Activity activity){
        return new AttendanceViewImpl(activity);
    }
}
