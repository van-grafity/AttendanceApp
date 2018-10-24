package id.co.ipos.hadir.attlogger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.co.ipos.hadir.attlogger.Activity.AttendanceActivity;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Logic_Case_InstrumentedTest{
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("id.co.ipos.hadir.attlogger", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<AttendanceActivity> activityTestRule
            = new ActivityTestRule<>(AttendanceActivity.class);



}
