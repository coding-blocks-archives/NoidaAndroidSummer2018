package com.example.shabnamkhatun.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1,number2;
    TextView result;
    Button add,subtract,divide,multiply;
    int num1,num2;

    int result_sum;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1=findViewById(R.id.number1);
        number2=findViewById(R.id.number2);
        result=findViewById(R.id.result);
        add=findViewById(R.id.add);
        subtract=findViewById(R.id.subtract);
        divide=findViewById(R.id.divide);
        multiply=findViewById(R.id.multiply);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1=Integer.parseInt(number1.getText().toString());
                num2=Integer.parseInt(number2.getText().toString());
                result_sum=num1+num2;
                result.setText(String.valueOf(result_sum));

            }
        });



        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1=Integer.parseInt(number1.getText().toString());
                num2=Integer.parseInt(number2.getText().toString());
                result_sum=num1-num2;
                result.setText(String.valueOf(result_sum));

            }
        });


        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1=Integer.parseInt(number1.getText().toString());
                num2=Integer.parseInt(number2.getText().toString());
                result_sum=num1/num2;
                result.setText(String.valueOf(result_sum));

            }
        });



        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1=Integer.parseInt(number1.getText().toString());
                num2=Integer.parseInt(number2.getText().toString());
                result_sum=num1*num2;
                result.setText(String.valueOf(result_sum));

            }
        });




    }

    public void reset(View view) {
        count=0;

        result.setText(String.valueOf(count));
    }
}
