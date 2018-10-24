package id.co.ipos.hadir.attlogger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.co.ipos.hadir.attlogger.Activity.AttendanceActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Logic_Case_InstrumentedTest{

    @Rule
    public ActivityTestRule<AttendanceActivity> activityTestRule
            = new ActivityTestRule<>(AttendanceActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        onView((withId(R.id.button_main))).perform(ViewActions.click());
        onView((withId(R.id.username))).perform(typeText("test_user"));
        onView((withId(R.id.password))).perform(typeText("test_password"));
        onView((withId(R.id.layout))).check(matches(isDisplayed()));

        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("id.co.ipos.hadir.attlogger", appContext.getPackageName());
    }


}
