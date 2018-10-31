package id.co.ipos.hadir.attlogger.Activity.Dagger;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

@Module
public class AttContextModule {
    private final Activity attendanceActivity;

    public AttContextModule(Activity attendanceActivity) {
        this.attendanceActivity = attendanceActivity;
    }

    @Provides
    @AttScope
    Activity provideAttContextModule(){
        return attendanceActivity;
    }
}
