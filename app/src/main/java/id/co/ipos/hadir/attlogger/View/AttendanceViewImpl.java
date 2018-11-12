package id.co.ipos.hadir.attlogger.View;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import butterknife.BindView;
import id.co.ipos.hadir.attlogger.R;

public class AttendanceViewImpl implements AttendanceView {
    @BindView(R.id.edUsername)
    EditText username;
    @BindView(R.id.edPassword)
    EditText password;
    private Activity m_activity;
    private View view;

    public AttendanceViewImpl(Activity activity) {
        this.m_activity = activity;
    }

    @Override
    public void showReadyState() {
        FrameLayout parent = new FrameLayout(m_activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(m_activity).inflate(R.layout.activity_ready_state, parent, true);
        m_activity.setContentView(view);
    }

    @Override
    public void showLoginState() {
        FrameLayout parent = new FrameLayout(m_activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(m_activity).inflate(R.layout.activity_login_state, parent, true);
        m_activity.setContentView(view);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void showDisplayError(String errorMesssage) {
        String error = "Error";

    }

    @Override
    public void downloadData() {

    }
}
