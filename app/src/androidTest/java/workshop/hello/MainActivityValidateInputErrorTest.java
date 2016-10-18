package workshop.hello;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityValidateInputErrorTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test public void
    empty_of_num1() {
        //Action
        onView(withId(R.id.num1)).perform(typeText(""));
        onView(withId(R.id.calBtn)).perform(click());

        //Assert
        onView(withId(R.id.num1)).check(matches(withError("This field is required")));
    }

    private Matcher<? super View> withError(final String expextedErrorMessage) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                EditText editText = (EditText) item;
                return editText.getError().toString().equals(expextedErrorMessage);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Not found error " + expextedErrorMessage);
            }
        };
    }


}