package id.co.ipos.hadir.attlogger;

import org.junit.Test;

import id.co.ipos.hadir.attlogger.Model.Attendance;
import id.co.ipos.hadir.attlogger.Model.AttendanceImpl;
import id.co.ipos.hadir.attlogger.Model.AttendanceState;

import static org.junit.Assert.assertEquals;


public class Attendance_model_UnitTest {

    @Test
    public void create_attendance_model() {
        Attendance attd = new AttendanceImpl();
        assertEquals(AttendanceState.Ready, attd.getState());
    }
}