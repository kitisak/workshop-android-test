package workshop.hello.network;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import workshop.hello.MainActivity;
import workshop.hello.R;
import workshop.hello.api.CalculatorApi;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class APIWithMockServerTest {


    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class, true, false);

    @Test
    public void
    call_add_api() throws IOException {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"result\": \"6.00\"}"));

        server.start();
        CalculatorApi.BASE_URL = server.url("/").toString();

        Intent intent = new Intent();
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.num1)).perform(typeText("3"));
        onView(withId(R.id.plusBtn)).perform(click());
        onView(withId(R.id.num2)).perform(typeText("2"));
        onView(withId(R.id.calBtn)).perform(click(), closeSoftKeyboard());

        onView(withId(R.id.result)).check(matches(withText("6.00")));

        server.shutdown();
    }

}
