package id.co.ipos.hadir.attlogger.Application;

import android.app.Application;

import id.co.ipos.hadir.attlogger.Application.Dagger.AppAttendanceComponent;
import id.co.ipos.hadir.attlogger.Application.Dagger.AppContextModule;
import id.co.ipos.hadir.attlogger.Application.Dagger.DaggerAppAttendanceComponent;

public class AppContext extends Application{
    private AppAttendanceComponent appAttendanceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();

        //appAttendanceComponent=this.createAppAttendanceComponent();
    }

    private void initAppComponent() {
        appAttendanceComponent = DaggerAppAttendanceComponent.builder()
                .appContextModule(new AppContextModule(this))
                .build();
    }

    /*private AppAttendanceComponent createAppAttendanceComponent(){
        return DaggerAppAttendanceComponent
                .builder()
                .appContextModule(new AppContextModule(this))
                .build();
    }*/
    public AppAttendanceComponent getAppAttendanceComponent(){
        return appAttendanceComponent;
    }
}
