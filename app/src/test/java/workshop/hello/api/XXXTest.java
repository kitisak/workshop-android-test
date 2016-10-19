package workshop.hello.api;

import android.content.Intent;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import workshop.hello.R;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by somkiat on 10/19/2016 AD.
 */

public class XXXTest {

    private MockWebServer server;

    @Before public void
    start() throws IOException {
        server = new MockWebServer();
    }

    @After public void
    stop() throws IOException {
        server.shutdown();
    }

    @Test @Ignore
    public void
    call_add_api() throws IOException, InterruptedException {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"result\": \"5.00\"}"));
        server.start();

        Request request = new Request.Builder()
                .url(server.url("/api/plus/3/2").toString())
                .build();

        MockCallback mockCallback = new MockCallback();

        CalculatorApi calculatorApi = new CalculatorApi();
        calculatorApi.setCallback(mockCallback);
        calculatorApi.setRequest(request);
        calculatorApi.add(3,2);

        Thread.sleep(1000);

        RecordedRequest request1 = server.takeRequest();
        assertEquals("/api/plus/3/2", request1.getPath());

        assertTrue(mockCallback.verify());
    }

}

