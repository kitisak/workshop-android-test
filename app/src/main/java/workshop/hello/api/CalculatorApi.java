package workshop.hello.api;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CalculatorApi {

    public static String BASE_URL = "http://128.199.198.13:30000" ;

    public interface CalculatorApiCallback {
        void onSuccess(String result);
    }

    private CalculatorApiCallback callback;
    private Request request;

    public void setCallback(CalculatorApiCallback callback) {
        this.callback = callback;
    }

    public void setRequest(Request request) {
        this.request = request;
    }


    public void add(int number1, int number2) {
        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                Gson gson = new Gson();
                Result result = gson.fromJson(response.body().charStream(), Result.class);
                callback.onSuccess(result.getResult());
            }
        });
    }

}
