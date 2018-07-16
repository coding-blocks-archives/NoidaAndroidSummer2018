package com.example.shabnamkhatun.calckotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes

import com.example.shabnamkhatun.calckotlin.R.id.add
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        add.setOnClickListener(){
            var num1=Integer.parseInt(number1.text.toString())
            var num2=Integer.parseInt(number2.text.toString())
            var  num=num1+num2
            result.setText(num.toString())

        }

        subtract.setOnClickListener(){
            var num1=Integer.parseInt(number1.text.toString())
            var num2=Integer.parseInt(number2.text.toString())
            var  num=num1-num2
            result.setText(num.toString())

        }


        divide.setOnClickListener(){
            var num1=Integer.parseInt(number1.text.toString())
            var num2=Integer.parseInt(number2.text.toString())
            var  num=num1/num2
            result.setText(num.toString())

        }



        multiply.setOnClickListener(){
            var num1=Integer.parseInt(number1.text.toString())
            var num2=Integer.parseInt(number2.text.toString())
            var  num=num1*num2
            result.setText(num.toString())

        }

        reset.setOnClickListener(){
            result.setText("")

        }



    }
}
