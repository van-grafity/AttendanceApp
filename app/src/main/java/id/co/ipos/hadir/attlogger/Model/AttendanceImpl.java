package id.co.ipos.hadir.attlogger.Model;

public class AttendanceImpl implements Attendance {

    private AttendanceState m_state;

    public AttendanceImpl() {
        this.m_state = AttendanceState.Ready;
    }

    @Override
    public AttendanceState getState() {
        return this.m_state;
    }


}
