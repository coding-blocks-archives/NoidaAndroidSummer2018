package com.codingblocks.calculatorlectr2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//comand+click on the method to see what is there in it

    public static final String TAG = "MainActivity";   //ek class ka ek tag
    EditText e1 , e2;
    TextView t;
    Float a ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.e(TAG,"on create fn called")   ;       //shift+" for that msg thing
        e1=findViewById(R.id.editText1);     // R class->integer
        e2=findViewById(R.id.editText2);
//        b = Float.valueOf(e1.getText().toString());
//        c = Float.valueOf(e2.getText().toString());
        t=findViewById(R.id.tv1);
    }



    public void add(View view){

        a = Float.valueOf(e1.getText().toString())+Float.valueOf(e2.getText().toString());

       t.setText(""+a);


    }

    public void sub(View view){

        a = Float.valueOf(e1.getText().toString())-Float.valueOf(e2.getText().toString());

        t.setText(""+a);
    }

    public void multiply(View view){
        a = Float.valueOf(e1.getText().toString())*Float.valueOf(e2.getText().toString());

        t.setText(""+a);
    }

    public void divide(View view){
        if(Float.valueOf(e2.getText().toString())!=0){
        a = Float.valueOf(e1.getText().toString())/Float.valueOf(e2.getText().toString());

        t.setText(""+a);}
        else{
            t.setText("invalid");

        }


    }

    public void reset(View view){
        a=0f;
        e1.setText("0.0");
        e2.setText("0.0");
        t.setText(""+a);

    }
    public void compute(View view) {
        switch (view.getId()) {
//            case  R.id.btnMinus :
//                //Do something
//                break;
//            case R.id.btnPlus :
//                //Do something
//                break;
//            case R.id.btnReset :
//                //Do something
            case R.id.power:
                double b;
              b =  Math.pow(Double.parseDouble(e1.getText().toString()),Double.parseDouble(e2.getText().toString()));
              t.setText(""+b);
              break;

            case R.id.factorial:
                   Float c=Float.valueOf(e1.getText().toString());

                  a = fact(c);
                  t.setText(""+a);
                  break;

            case R.id.sin:
                Float c2=Float.valueOf(e1.getText().toString());
         Double a1 = Math.sin(c2);
                t.setText(""+a1);


        }
    }
    public Float fact(float n){
       if(n==1||n==0){
           return 1f;
       }

        return  (n * fact(n-1));
    }
}
