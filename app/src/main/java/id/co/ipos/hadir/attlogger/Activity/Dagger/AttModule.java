package id.co.ipos.hadir.attlogger.Activity.Dagger;

import android.app.Activity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenter;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenterImpl;
import id.co.ipos.hadir.attlogger.View.AttendanceView;
import id.co.ipos.hadir.attlogger.View.AttendanceViewImpl;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class AttModule {
    @AttScope
    @Provides
    AttendancePresenter provideAttendancePresenter(){
        return new AttendancePresenterImpl();
    }
    @AttScope
    @Provides
    AttendanceView provideAttendanceView(Activity activity){
        return new AttendanceViewImpl(activity);
    }
    @AttScope
    @Provides
    @Named("androidScheduler")
    Scheduler provideAndroidScheduler(){
        return AndroidSchedulers.mainThread();
    }
    @AttScope
    @Provides
    @Named("processScheduler")
    Scheduler provideProcessScheduler(){
        return Schedulers.newThread();
    }
}
