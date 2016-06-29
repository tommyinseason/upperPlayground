package com.example.guest.businessmodel;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

/**
 * Created by Guest on 6/29/16.
 */
public class MainActivityTest {

        private MainActivity activity;

        @Before
        public void setup() {
            activity = Robolectric.setupActivity(MainActivity.class);
        }

        @Test
        public void validateTextViewContent() {
            TextView appNameTextView = (TextView) activity.findViewById(R.id.appNameTextView);
            assertTrue("Uppper PlayGround".equals(appNameTextView.getText().toString()));
        }

        @Test
        public void secondActivityStarted() {
            activity.findViewById(R.id.findShoesButton).performClick();
            Intent expectedIntent = new Intent(activity, ShoesActivity.class);
            ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
            Intent actualIntent = shadowActivity.getNextStartedActivity();
            assertTrue(actualIntent.filterEquals(expectedIntent));
        }
}
