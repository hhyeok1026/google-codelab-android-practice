package com.example.twoactivities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

/**
 * The Two Activities app provides a text entry field and a Send button (the
 * button_main id). Clicking Send launches the Second activity with the entered
 * text shown in the text_header view of the Second activity.
 *
 * The first Espresso test performs a click on the main activity's button, and
 * checks to see if the text_header matches what is displayed. If it passes, it
 * means that the second activity was started. The test then clicks the second
 * activity's button, and checks to see if the text_header_reply matches what is
 * displayed. If it passes, it means that the main activity was started from the
 * second activity.
 *
 * The second test locates the view containing the editText_main view, enters
 * the text "This is a test." and clicks the main button. It then compares the
 * text_message with the assertion "This is a test." If it passes, it means that
 * the entered text was successfully passed to the text_message field.
 */

@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    /*    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);*/

    //public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.twoactivities",
                appContext.getPackageName());
    }

    @Test
    public void activityLaunch() {
        onView(withId(R.id.button_main)).perform(click());
        onView(withId(R.id.text_header)).check(matches(isDisplayed()));
        onView(withId(R.id.button_second)).perform(click());
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()));
    }

    @Test
    public void textInputOutput() {
        onView(withId(R.id.editText_main)).perform(
                typeText("This is a test."));
        onView(withId(R.id.button_main)).perform(click());
        onView(withId(R.id.text_message)).check(
                matches(withText("This is a failing test.")));
    }
}