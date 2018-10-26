package id.co.ipos.hadir.attlogger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.co.ipos.hadir.attlogger.Activity.AttendanceActivity;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStore;
import id.co.ipos.hadir.attlogger.Infrastruktur.TokenStoreImpl;

@RunWith(AndroidJUnit4.class)
public class Token_Store_Impl_instrumentedTest {



    @Rule
    public ActivityTestRule<AttendanceActivity> attActivity =
            new ActivityTestRule<>(AttendanceActivity.class);

    @Test
    public void is_token_exist() {
        TokenStore tokenStore=new TokenStoreImpl(attActivity.getActivity().getApplicationContext());
        boolean result = tokenStore.isTokenExist();
        Assert.assertTrue(result);
    }

}
