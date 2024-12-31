package com.walisaalam.class3

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity2 : AppCompatActivity() {
    private var firstNumber =""
    private var currentNumber =""
    private var currentOperator =""
    private var result =""

    private lateinit var display: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        display = findViewById(R.id.plain_text_input)
        setupButtons()
    }
    private fun setupButtons() {
        // Number buttons
//        findViewById<LinearLayout>(R.id.).setOnClickListener { appendNumber("0") }
//        findViewById<LinearLayout>(R.id._1).setOnClickListener { appendNumber("1") }
//        findViewById<LinearLayout>(R.id._2).setOnClickListener { appendNumber("2") }
//        findViewById<LinearLayout>(R.id._3).setOnClickListener { appendNumber("3") }
//        findViewById<LinearLayout>(R.id._4).setOnClickListener { appendNumber("4") }
//        findViewById<LinearLayout>(R.id._5).setOnClickListener { appendNumber("5") }
//        findViewById<LinearLayout>(R.id._6).setOnClickListener { appendNumber("6") }
//        findViewById<LinearLayout>(R.id._7).setOnClickListener { appendNumber("7") }
//        findViewById<LinearLayout>(R.id._8).setOnClickListener { appendNumber("8") }
//        findViewById<LinearLayout>(R.id._9).setOnClickListener { appendNumber("9") }
//        findViewById<LinearLayout>(R.id._dot).setOnClickListener { appendNumber(".") }
//        findViewById<LinearLayout>(R.id.plain_text_input1).setOnClickListener { reset() }
//
//        // Operator buttons
//        findViewById<LinearLayout>(R.id._plus).setOnClickListener { setOperator("+") }
//        findViewById<LinearLayout>(R.id._min).setOnClickListener { setOperator("-") }
//        findViewById<LinearLayout>(R.id._X).setOnClickListener { setOperator("X") }
//        findViewById<LinearLayout>(R.id._div).setOnClickListener { setOperator("/") }
//        findViewById<LinearLayout>(R.id._eq).setOnClickListener { calculateResult() }

    }

    private fun reset(){
        display.text = ""
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        display.text = currentNumber
        Log.d("ButtonClick", "Button clicked: 0")
    }
    private fun setOperator(operator: String) {
        if (currentNumber.isNotEmpty()) {
            firstNumber = currentNumber
            currentNumber = ""
            currentOperator = operator
            display.text = firstNumber + currentOperator
        }
    }
    private fun calculateResult() {
        if (firstNumber.isNotEmpty() && currentNumber.isNotEmpty()) {
            try {
                val num1 = firstNumber.toDouble()
                val num2 = currentNumber.toDouble()

                result = when (currentOperator) {
                    "+" -> (num1 + num2).toString()
                    "-" -> (num1 - num2).toString()
                    "X" -> (num1 * num2).toString()
                    "/" -> if (num2 != 0.0) {
                        (num1 / num2).toString()
                    } else {
                        "Error"
                    }
                    else -> "Error"
                }
                display.text = result

                // Clear the operator and numbers for next operation
                firstNumber = result
                currentNumber = ""
                currentOperator = ""

            } catch (e: Exception) {
                display.text = "Error"
            }
        } else {
            display.text = ""
        }
    }
}