package com.toy.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val count = constraint_layout.childCount - 2
        for (x in 0..count) {
            constraint_layout.getChildAt(x).setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        when ((v as TextView).text) {
            "=" -> {
                if (tv_result.text.isEmpty()||!tv_result.text[0].isDigit()) return
                when (operation) {
                    "+" -> result += tv_result.text.toString().toDouble()
                    "-" -> result -= tv_result.text.toString().toDouble()
                    "x" -> result *= tv_result.text.toString().toDouble()
                }
                var resultStr = result.toString()
                resultStr = if (resultStr.endsWith(".0")) resultStr.replace(".0", "") else resultStr
                tv_result.text = resultStr
                str = ""
                result = 0.0
            }
            "+","-","x","AC" -> {
                clearStatus(v.text.toString())
                operation = v.text.toString()
            }

            else -> {
                str += v.text
                tv_result.text = str
            }
        }
    }

    private fun clearStatus(operator: String) {
        result = if (!tv_result.text.isEmpty()&&tv_result.text[0].isDigit()) tv_result.text.toString().toDouble() else 0.0
        tv_result.text = operator
        str = ""
    }


}


