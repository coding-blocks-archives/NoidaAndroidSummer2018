package com.example.raghav.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    TextView result;
    Button add,subtract,multiply,divide;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=findViewById(R.id.Text1);
        num2=findViewById(R.id.Text2);

        result=findViewById(R.id.result);

        add=findViewById(R.id.button);
        subtract=findViewById(R.id.button2);
        multiply=findViewById(R.id.button3);
        divide=findViewById(R.id.button4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num1.getText() != null && num2.getText() != null) {
                    int input1 = Integer.parseInt(num1.getText().toString());  //get input
                    int input2 = Integer.parseInt(num2.getText().toString());

                    int res = input1 + input2;

                    result.setText(String.valueOf(res)); //show
                    );


                } else {
                    Toast.makeText(view.getContext(), "please enter valid no", Toast.LENGTH_LONG).show();

                }
            }

    });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num1.getText() != null && num2.getText() != null) {
                    int input1 = Integer.parseInt(num1.getText().toString());  //get input
                    int input2 = Integer.parseInt(num2.getText().toString());

                    int res = input1 - input2;

                    result.setText(String.valueOf(res)); //show


                } else {
                    Toast.makeText(view.getContext(), "please enter valid no", Toast.LENGTH_LONG).show();

                }
            }

        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num1.getText() != null && num2.getText() != null) {
                    int input1 = Integer.parseInt(num1.getText().toString());  //get input
                    int input2 = Integer.parseInt(num2.getText().toString());

                    int res = input1 * input2;

                    result.setText(String.valueOf(res)); //show


                } else {
                    Toast.makeText(view.getContext(), "please enter valid no", Toast.LENGTH_LONG).show();

                }
            }

        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num1.getText() != null && num2.getText() != null) {
                    int input1 = Integer.parseInt(num1.getText().toString());  //get input
                    int input2 = Integer.parseInt(num2.getText().toString());

                    int res = input1 / input2;

                    result.setText(String.valueOf(res)); //show


                } else {
                    Toast.makeText(view.getContext(), "please enter valid no", Toast.LENGTH_LONG).show();

                }

                }


            });


}
}
