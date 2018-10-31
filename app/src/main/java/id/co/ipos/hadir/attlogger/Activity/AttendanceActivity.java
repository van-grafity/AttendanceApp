package id.co.ipos.hadir.attlogger.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import id.co.ipos.hadir.attlogger.Activity.Dagger.AttContextModule;
import id.co.ipos.hadir.attlogger.Activity.Dagger.DaggerAttComponent;
import id.co.ipos.hadir.attlogger.Application.AppContext;
import id.co.ipos.hadir.attlogger.Application.Dagger.AppAttendanceComponent;
import id.co.ipos.hadir.attlogger.Presenter.AttendancePresenter;

public class AttendanceActivity extends AppCompatActivity {

    @Inject
    AttendancePresenter attendancePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBar();

        injectDependenciesUsingDagger();

        this.attendancePresenter.prepare();
    }

    private void injectDependenciesUsingDagger() {
        AppAttendanceComponent appComp=((AppContext)getApplication()).getAppAttendanceComponent();
        DaggerAttComponent.builder()
                .appAttendanceComponent(appComp)
                .attContextModule(new AttContextModule(this))
                .build()
                .inject(this);
    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }


}
