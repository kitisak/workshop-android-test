package workshop.hello;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(Parameterized.class)
public class MainActivityAddWithDataTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    private String number1;
    private String number2;
    private String expectedResult;

    public MainActivityAddWithDataTest(String number1, String number2, String expectedResult) {
        this.number1 = number1;
        this.number2 = number2;
        this.expectedResult = expectedResult;
    }

    @Parameters(name = "{index}=>{0} + {1} = {2}" )
    public static List<Object[]> setUpData() {
        return Arrays.asList(new Object[][] {
                {"1", "1", "2.00"},
                {"1", "2", "3.00"},
                {"10", "2", "12.00"}
        });
    }


    @Test public void
    plus() {
        //Action
        onView(withId(R.id.num1)).perform(typeText(number1));
        onView(withId(R.id.plusBtn)).perform(click());
        onView(withId(R.id.num2)).perform(typeText(number2));
        onView(withId(R.id.calBtn)).perform(click(), closeSoftKeyboard());

        //Assert
        onView(withId(R.id.result)).check(matches(withText(expectedResult)));
    }

}