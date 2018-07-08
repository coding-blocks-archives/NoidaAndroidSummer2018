package garg.ayush.calc_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        add.setOnClickListener(){
            var N1 = Integer.parseInt(num1.text.toString())
            var N2 = Integer.parseInt(num2.text.toString())
            var num= N1+N2
            result.setText(num.toString())
        }

        sub.setOnClickListener(){
            var N1 = Integer.parseInt(num1.text.toString())
            var N2 = Integer.parseInt(num2.text.toString())
            var num= N1-N2
            result.setText(num.toString())
        }

        mul.setOnClickListener(){
            var N1 = Integer.parseInt(num1.text.toString())
            var N2 = Integer.parseInt(num2.text.toString())
            var num= N1*N2
            result.setText(num.toString())
        }

        div.setOnClickListener(){
            var N1 = Integer.parseInt(num1.text.toString())
            var N2 = Integer.parseInt(num2.text.toString())
            var num= N1/N2
            result.setText(num.toString())
        }

    }
}
