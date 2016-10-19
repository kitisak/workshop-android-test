package workshop.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.Request;
import workshop.hello.api.CalculatorApi;
import workshop.hello.controller.MainController;

public class MainActivity extends AppCompatActivity implements MainController.MainControllerCallback {

    private TextView resultTV;
    private EditText num1ET;
    private EditText num2ET;
    private Button minusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = (TextView) findViewById(R.id.result);
        num1ET = (EditText) findViewById(R.id.num1);
        num2ET = (EditText) findViewById(R.id.num2);
        minusBtn = (Button) findViewById(R.id.minusBtn);
    }

    public void onCalculate(View view) {
        MainController mainController = new MainController(this);
        mainController.calculate(num1ET.getText().toString()
                , num2ET.getText().toString()
                , this.currentOperation);
    }

    private Operation currentOperation = Operation.ADD;

    private Operation getCurrentOperation() {
        return this.currentOperation;
    }

    public void onMinus(View view) {
        this.currentOperation = Operation.Minus;
    }

    public void onAdd(View view) {
        this.currentOperation = Operation.ADD;
    }

    @Override
    public void showErrorRequiredOfNumber1() {
        this.num1ET.setError("This field is required");
    }

    @Override
    public void showResult(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                resultTV.setText(result);
            }
        });
    }

    public enum Operation {
        ADD, Minus
    }

}

