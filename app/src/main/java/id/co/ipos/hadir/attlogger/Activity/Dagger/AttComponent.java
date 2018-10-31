package id.co.ipos.hadir.attlogger.Activity.Dagger;

import dagger.Component;
import id.co.ipos.hadir.attlogger.Activity.AttendanceActivity;
import id.co.ipos.hadir.attlogger.Application.Dagger.AppAttendanceComponent;

@AttScope
@Component (modules = {AttModule.class, AttContextModule.class}, dependencies = {AppAttendanceComponent.class})
public interface AttComponent {
    void inject(AttendanceActivity attendanceActivity);
}
