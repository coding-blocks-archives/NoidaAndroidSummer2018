package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String string = "";
    public static final String TAG = "PROGRAM STOP";
    String s1,s2;

    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    String s = "";



    public void numberClick(View view) {

            switch (view.getId()) {
                case R.id.nine:
                    s = "9";
                    string += s;
                    break;
                case R.id.eight:
                    s = "8";
                    string += s;
                    break;


                case R.id.seven:
                    s = "7";
                    string += s;
                    break;


                case R.id.six:
                    s = "6";
                    string += s;
                    break;
                case R.id.five:
                    s = "5";
                    string += s;
                    break;
                case R.id.four:
                    s = "4";
                    string += s;
                    break;
                case R.id.three:
                    s = "3";
                    string += s;
                    break;
                case R.id.two:
                    s = "2";
                    string += s;
                    break;
                case R.id.one:
                    s = "1";
                    string += s;
                    break;
                case R.id.zero:
                    s="0";
                    string += s;
                    break;
                case R.id.dot:
                    s=".";
                    string += s;
                    break;
                case R.id.equal1: {
                    String s = "Equal Button Click.";
                    calculate();
                    break;
                }
                case R.id.del:
                    string = string.substring(0, string.length() - 1);
                    break;
                case R.id.div:
                    s = "\u00F7";
                    string += s;
                    break;
                case R.id.mul:
                    s = "\u00D7";
                    string += s;
                    break;
                case R.id.minus:
                    s = "-";
                    string += s;
                    break;
                case R.id.plus:
                    s = "+";
                    string += s;
                    break;


            }
          display(string);
            Log.e(TAG, "numberClick: "+string );




    }
    public void display(String s){
       TextView textView = findViewById(R.id.textView);
        textView.setText(s);
    }

    public void display1(String s){
        TextView textView = findViewById(R.id.ansTextView);
        textView.setText(s);
    }

    public void calculate(){
        if(string.indexOf('+') >  0){

            s1 = string.substring(0,string.indexOf('+'));
            s2= string.substring(string.indexOf('+')+1,string.length());
            result = Double.parseDouble(s1)+Double.parseDouble(s2);

        }
        else if(string.indexOf('-') >  0){

            s1 = string.substring(0,string.indexOf('-'));
            s2= string.substring(string.indexOf('-')+1,string.length());
            result = Double.parseDouble(s1)-Double.parseDouble(s2);

        }
        else if(string.indexOf('/') >  0){

            s1 = string.substring(0,string.indexOf('/'));
            s2= string.substring(string.indexOf('/')+1,string.length());
            result = Double.parseDouble(s1)/Double.parseDouble(s2);

        }
        else if(string.indexOf('*') >  0){

            s1 = string.substring(0,string.indexOf('*'));
            s2= string.substring(string.indexOf('*')+1,string.length());
            result = Double.parseDouble(s1)*Double.parseDouble(s2);

        }
       String ans = "= " + String.valueOf(result);
        display1(ans);

    }

}
