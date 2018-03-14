package cn.com.tianyudg.autotestdemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;

/**
 * Author : WaterFlower.
 * Created on 2018/3/14.
 * Desc :
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);

//    @Test
//    public void testHelloWorldTextView()
//    {
//        onView(allOf(withText("Hello World!"),instanceOf(TextView.class)))
//        .check(matches(isDisplayed()));
//    }

    @Test
    public void testClickButton() throws InterruptedException {
        onView(allOf(withText("点击"), instanceOf(Button.class)))
                .check(matches(isDisplayed()))
                .perform(click());

        Thread.sleep(2000);
        onView(withText("hello hola"))
                .inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));


    }
}
