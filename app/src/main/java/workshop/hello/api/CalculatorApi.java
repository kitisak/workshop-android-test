package workshop.hello.api;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CalculatorApi {

    public interface CalculatorApiCallback {
        void onSuccess(int result);
    }

    private CalculatorApiCallback callback;

    public void setCallback(CalculatorApiCallback callback) {
        this.callback = callback;
    }

    public void add(int number1, int number2) {
        String url = String.format("http://128.199.198.13:3000/api/plus/%d/%d", number1, number2);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

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

                try {
                    String responseData = response.body().string();
                    JSONObject json = new JSONObject(responseData);
                    callback.onSuccess(json.getInt("result"));
                } catch (JSONException e) {

                }

            }
        });
    }

}
