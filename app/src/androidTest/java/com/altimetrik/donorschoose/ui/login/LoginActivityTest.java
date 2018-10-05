package com.altimetrik.donorschoose.ui.login;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.altimetrik.donorschoose.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by José Guadalupe Mandujano on 10/5/18.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(
            LoginActivity.class);

    @Test
    public void checkUserNameEditTextIsDisplayed() {
        onView(withId(R.id.email)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPasswordEditTextIsDisplayed() {
        onView(withId(R.id.password)).check(matches(isDisplayed()));
    }

    @Test
    public void checkErrorMessageIsDisplayedForEmptyData() {
        onView(withId(R.id.email_login_form)).check(matches(isDisplayed())).perform(click());
        onView(withText("Please check Username or Password.")).check(matches(isDisplayed()));
    }

    @Test
    public void checkLoginSuccess() {
        onView(withId(R.id.email)).perform(typeText("user1"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.email_login_form)).check(matches(isDisplayed())).perform(click());
        onView(withText("Login successful.")).check(matches(isDisplayed()));

    }
}