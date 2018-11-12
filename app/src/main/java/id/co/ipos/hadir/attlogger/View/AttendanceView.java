package id.co.ipos.hadir.attlogger.View;

public interface AttendanceView {
    void showReadyState();

    void showLoginState();

    String getUsername();

    String getPassword();

    void showDisplayError(String errorMessage);

    void downloadData();
}
