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
        val count = constraint_layout.childCount - 1
        for (x in 0..count) {
            constraint_layout.getChildAt(x).setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        if (v?.id==R.id.tv_result)return
        if (v is TextView) {
            when (v.text) {
                " = " -> {
                    if (tv_result.text.isEmpty()) return
                    when (suanfa) {
                        "+" -> result += tv_result.text.toString().toDouble()
                        "-" -> result -= tv_result.text.toString().toDouble()
                        "x" -> result *= tv_result.text.toString().toDouble()
                    }
                    var resultStr = result.toString()
                    resultStr = if (resultStr.endsWith(".0")) resultStr.replace(".0", "") else resultStr
                    tv_result.text = resultStr
                    str=""
                    result = 0.0
                }
                " + " -> {
                    clearStatus("+")
                    suanfa = "+"
                }
                " - " -> {
                    clearStatus("-")
                    suanfa = "-"
                }
                " x " -> {
                    clearStatus("x")
                    suanfa = "x"
                }
                "AC" -> {
                   clearStatus("")
                }
                else -> {
                    str += v.text
                    tv_result.text = str
                }
            }
        }
    }

    private fun clearStatus(fuhao:String) {
        result = if (tv_result.text.isEmpty()) 0.0 else tv_result.text.toString().toDouble()
        tv_result.text = fuhao
        str = ""
    }


}


