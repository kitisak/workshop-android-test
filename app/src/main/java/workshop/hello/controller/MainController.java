package workshop.hello.controller;


import android.util.Log;

import okhttp3.Request;
import workshop.hello.Calculator;
import workshop.hello.MainActivity;
import workshop.hello.api.CalculatorApi;

public class MainController implements CalculatorApi.CalculatorApiCallback {

    public interface MainControllerCallback {
        void showErrorRequiredOfNumber1();
        void showResult(String result);
    }

    private MainControllerCallback mainControllerCallback;

    public MainController(MainControllerCallback mainControllerCallback) {
        this.mainControllerCallback = mainControllerCallback;
    }

    public void calculate(String number1, String number2, MainActivity.Operation currentOperation) {
        if(!validate(number1)) {
            return;
        }
        //TODO
        Calculator calculator = new Calculator();
        int _number1 = Integer.parseInt(number1);
        int _number2 = Integer.parseInt(number2);
        double result = 0.0;
        if(MainActivity.Operation.Minus == currentOperation) {
//            result = calculator.minus(_number1, _number2);
            String url = String.format("%s/api/minus/%d/%d", CalculatorApi.BASE_URL, _number1, _number2);
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            CalculatorApi calculatorApi = new CalculatorApi();
            calculatorApi.setRequest(request);
            calculatorApi.setCallback(this);
            calculatorApi.add(_number1, _number2);
        } else {
//            result = calculator.add(_number1, _number2);
            String url = String.format("%s/api/plus/%d/%d", CalculatorApi.BASE_URL, _number1, _number2);
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            CalculatorApi calculatorApi = new CalculatorApi();
            calculatorApi.setRequest(request);
            calculatorApi.setCallback(this);
            calculatorApi.add(_number1, _number2);
        }
//        mainControllerCallback.showResult(String.format("%.2f", result));
    }

    private boolean validate(String number1) {
        if( number1.length() == 0 ) {
            mainControllerCallback.showErrorRequiredOfNumber1();
            return false;
        }
        return true;
    }

    @Override
    public void onSuccess(String result) {
        mainControllerCallback.showResult(result);
    }

}
