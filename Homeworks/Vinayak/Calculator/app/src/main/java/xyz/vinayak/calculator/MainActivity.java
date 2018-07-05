package xyz.vinayak.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    EditText num1Et;
    EditText num2Et;
    TextView resultTv;
    TextView operationSignTv;
    char operation = '`';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1Et = findViewById(R.id.num1Et);
        num2Et = findViewById(R.id.num2Et);
        num2Et.requestFocus();
        resultTv = findViewById(R.id.resultTv);
        operationSignTv = findViewById(R.id.operationSignTv);
    }

    public void compute(View view) {
        num1Et.setText(num2Et.getText().toString());
        num2Et.setText("");
        switch (view.getId()){
            case R.id.btnAdd :
                operation = '+';
                operationSignTv.setText("+");
                break;
            case R.id.btnMinus :
                operation = '-';
                operationSignTv.setText("-");
                break;
            case R.id.btnMultiply :
                operation = 'x';
                operationSignTv.setText("x");
                break;
            case R.id.btnDivide :
                operation = '/';
                operationSignTv.setText("/");
                break;
        }
    }

    public void append(View view) {
        String appendText = num2Et.getText().toString();
        switch (view.getId()){
            case R.id.num1 :
                appendText = appendText + "1";
                break;
            case R.id.num2 :
                appendText = appendText + "2";
                break;
            case R.id.num3 :
                appendText = appendText + "3";
                break;
            case R.id.num4 :
                appendText = appendText + "4";
                break;
            case R.id.num5 :
                appendText = appendText + "5";
                break;
            case R.id.num6 :
                appendText = appendText + "6";
                break;
            case R.id.num7 :
                appendText = appendText + "7";
                break;
            case R.id.num8 :
                appendText = appendText + "8";
                break;
            case R.id.num9 :
                appendText = appendText + "9";
                break;
            case R.id.num0 :
                appendText = appendText + "0";
                break;
        }
        num2Et.setText(appendText);
    }

    public void dispResult(View view) {
        operationSignTv.setText("");
        int num1 = Integer.parseInt(num1Et.getText().toString());
        int num2 = Integer.parseInt(num2Et.getText().toString());
        int result=0;
        switch (operation){
            case '+':
                result = num1 + num2;
                Log.e(TAG, "dispResult: Addition result = " + result + " num1 = " + num1 + " num2 = " + num2 );
                break;
            case '-':
                result = num1 - num2;
                Log.e(TAG, "dispResult: Minus result = " + result + " num1 = " + num1 + " num2 = " + num2 );
                break;
            case 'x':
                result = num1 * num2;
                Log.e(TAG, "dispResult: Multiply result = " + result + " num1 = " + num1 + " num2 = " + num2 );
                break;
            case '/':
                result = num1 / num2;
                Log.e(TAG, "dispResult: Divide result = " + result + " num1 = " + num1 + " num2 = " + num2 );
                break;
        }
        resultTv.setText(String.valueOf(result));
        num1Et.setText("");
        num2Et.setText("");
    }
}
