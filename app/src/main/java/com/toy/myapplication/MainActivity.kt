package com.toy.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic


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
        if (v is TextView) {
            when (v.text) {
                " = " -> computeAll(str)
                " + " -> computeAdd()
                " - " -> computeSubtraction()
                " x " -> computeMultiplication()
                "AC" -> clearAll()
                else -> doElse(v.text)
            }
        }
    }

    private fun computeMultiplication() {
        result = tv_result.text.toString().toInt()
        tv_result.text = ""
        str = ""
        suanfa = "x"

    }

    private fun computeSubtraction() {

        result = tv_result.text.toString().toInt()
        tv_result.text = ""
        str = ""
        suanfa = "-"

    }

    private fun clearAll() {
        tv_result.text = ""
        str = ""
        result = 0
    }

    private fun doElse(text: CharSequence?) {
        str += text
        tv_result.text = str
    }


    private fun computeAdd() {
        result = tv_result.text.toString().toInt()
        tv_result.text = ""
        str = ""
        suanfa = "+"
    }

    private fun computeAll(str: String) {
        when (suanfa) {
            "+" -> result += tv_result.text.toString().toInt()
            "-" -> result -= tv_result.text.toString().toInt()
            "x" -> result *= tv_result.text.toString().toInt()

        }
        tv_result.text = result.toString()
        result = 0
    }



}


