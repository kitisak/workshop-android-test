package workshop.hello;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@Category(Iteration001.class)
public class MainActivityMinusTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test public void
    one_plus_one_should_be_zero() {
        //Action
        onView(withId(R.id.num1)).perform(typeText("1"));
        onView(withId(R.id.minusBtn)).perform(click());
        onView(withId(R.id.num2)).perform(typeText("1"));
        onView(withId(R.id.calBtn)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("0.0")));
    }

}