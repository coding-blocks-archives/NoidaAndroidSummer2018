package com.example.dell.calcii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
TextView text;
TextView textRes;
TextView text2;
TextView sig;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnplus;
    Button btnneg;
    Button btnmul;
    Button btndiv;
    Button btndot;
    Button btn0;
    Button btnequ;
    Button btnd;
    int a=0;
    int num=0,num1=0;
    int k=0,s=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sig=findViewById(R.id.sign);
        btnd=findViewById(R.id.btndel);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn0=findViewById(R.id.btnzero);
        btnneg=findViewById(R.id.btnNeg);
        btnmul=findViewById(R.id.btnMul);
        btndiv=findViewById(R.id.btnDiv);
        btndot=findViewById(R.id.btndot);
        text=findViewById(R.id.editText);
        text2=findViewById(R.id.editText2);
        btnplus=findViewById(R.id.btnplus);
        btnequ=findViewById(R.id.equal);
        textRes=findViewById(R.id.TextOut);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == 0) {
                    num = num * 10 + 1;
                    text.setText(""+num);
                } else {
                    num1 = num1 * 10 + 1;
                    text2.setText(""+num1);
                }
            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0){
                num=num/10;
                text.setText(""+num);}
                else {
                    num1 /= 10;
                    if(num1>0)
                    text2.setText(""+num1);
                    else
                        text2.setText("");
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                { num=num*10+2;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+2;
                    text2.setText(""+num1);
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                {
                    num=num*10+3;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+3;
                    text2.setText(""+num1);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                {
                    num=num*10+4;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+4;
                    text2.setText(""+num1);
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                {
                    num=num*10+5;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+5;
                    text2.setText(""+num1);
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                {
                    num=num*10+6;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+6;
                    text2.setText(""+num1);
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                {
                    num=num*10+7;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+7;
                    text2.setText(""+num1);
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                { num=num*10+8;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+8;
                    text2.setText(""+num1);
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                {
                    num=num*10+9;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+9;
                    text2.setText(""+num1);
                }
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                {
                    num=num*10+0;
                    text.setText(""+num);

                }else
                {
                    num1=num1*10+0;
                    text2.setText(""+num1);
                }
            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String S= String.valueOf(num)+'+';
                //text.setText(S);
                a=1;
                sig.setText("+");
            }
        });
        btnneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
a=2;
                sig.setText("-");
             /*   a = 2;
                k=1;
                if (k > 1) {
                    switch (s) {
                        case 1:
                            num = num + num1;
                            break;
                        case 2:
                            num = num - num1;
                            break;
                        case 3:
                            num = num * num1;
                            break;
                        case 4:
                            num = num / num1;
                            break;

                    }
                    sig.setText("-");
                    num1 = 0;
                    text.setText("" + num);
                    text2.setText("");
                    k = 0;
                } else
                    sig.setText("-");
                s=2;*/
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String S= String.valueOf(num)+'*';
                //text.setText(S);
                a=3;
                sig.setText("*");

               /* k=1;
            if(k>1)
            {   switch (s) {
                case 1:num = num + num1;
                    break;
                case 2:num = num - num1;
                    break;
                case 3:num = num * num1;
                    break;
                case 4:num = num / num1;
                    break;

            }sig.setText("*");
                num1=0;
                text.setText(""+num);
                text2.setText("");
                k=0;
            }else
            {sig.setText("*");
            k++;
s=3;}*/
            }

        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String S= String.valueOf(num)+'/';
                //text.setText(S);
                a = 4;
                sig.setText("/");

/*        k=1;
        if(k>1)
        {   switch (s) {
            case 1:num = num + num1;
                break;
            case 2:num = num - num1;
                break;
            case 3:num = num * num1;
                break;
            case 4:num = num / num1;
                break;

        }sig.setText("/");
            num1=0;
            text.setText(""+num);
            text2.setText("");
            k=0;
        }else
            sig.setText("-");
s=4;*/
            }
        });

        btnequ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (a){
                    case 1:  num=num+num1;
                             break;
                    case 2:  num=num-num1;
                             break;
                    case 3:  num=num*num1;
                             break;
                    case 4:  num=num/num1;
                }
             //   num1=0;
               // text2.setText("");
                textRes.setText(""+num);
/*                num1=0;
                if(k>1)
                 {
                     text2.setText("");
                 }*/
            }
        });

    }
}
