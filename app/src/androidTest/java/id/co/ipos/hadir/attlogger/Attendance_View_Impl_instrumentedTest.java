package id.co.ipos.hadir.attlogger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.co.ipos.hadir.attlogger.Activity.AttendanceActivity;
import id.co.ipos.hadir.attlogger.View.AttendanceViewImpl;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class Attendance_View_Impl_instrumentedTest {

    private AttendanceViewImpl m_attendanceView;
    @Rule
    public ActivityTestRule<AttendanceActivity> attActivity
            = new ActivityTestRule<>(AttendanceActivity.class);

    @Before
    public void setUp() {
        m_attendanceView = new AttendanceViewImpl(attActivity.getActivity());
    }

    @Test
    public void show_ready_state() throws Throwable {
        attActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                m_attendanceView.showReadyState();
            }
        });

        onView(withId(R.id.tvReady)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_readyState)).check(matches(isDisplayed()));
    }

    @Test
    public void show_login_state() throws Throwable {
        attActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                m_attendanceView.showLoginState();
            }
        });

        onView(withId(R.id.edUsername)).check(matches(isDisplayed()));
        onView(withId(R.id.edPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

}

