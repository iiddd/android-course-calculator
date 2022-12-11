package com.iiddd.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var btn0: Button? = null
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null
    private var btn4: Button? = null
    private var btn5: Button? = null
    private var btn6: Button? = null
    private var btn7: Button? = null
    private var btn8: Button? = null
    private var btn9: Button? = null
    private var btnDivision: Button? = null
    private var btnMultiply: Button? = null
    private var btnMinus: Button? = null
    private var btnPlus: Button? = null
    private var btnClear: Button? = null
    private var btnResult: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initKeyboard()
        btn0?.setOnClickListener {
            onDigit()
        }

        btn1?.setOnClickListener {
            onDigit()
        }

        btn2?.setOnClickListener {
            onDigit()
        }

        btn3?.setOnClickListener {
            onDigit()
        }

        btn4?.setOnClickListener {
            onDigit()
        }

        btn5?.setOnClickListener {
            onDigit()
        }

        btn6?.setOnClickListener {
            onDigit()
        }

        btn7?.setOnClickListener {
            onDigit()
        }

        btn8?.setOnClickListener {
            onDigit()
        }

        btn9?.setOnClickListener {
            onDigit()
        }

        btnDivision?.setOnClickListener {
            onDigit()
        }

        btnMultiply?.setOnClickListener {
            onDigit()
        }

        btnMinus?.setOnClickListener {
            onDigit()
        }

        btnPlus?.setOnClickListener {
            onDigit()
        }

        btnClear?.setOnClickListener {
            onDigit()
        }

        btnResult?.setOnClickListener {
            onDigit()
        }
    }

    private fun onDigit() {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show()
    }

    private fun initKeyboard() {
        btn0 = findViewById(R.id.buttonZero)
        btn1 = findViewById(R.id.buttonOne)
        btn2 = findViewById(R.id.buttonTwo)
        btn3 = findViewById(R.id.buttonThree)
        btn4 = findViewById(R.id.buttonFour)
        btn5 = findViewById(R.id.buttonFive)
        btn6 = findViewById(R.id.buttonSix)
        btn7 = findViewById(R.id.buttonSeven)
        btn8 = findViewById(R.id.buttonEight)
        btn9 = findViewById(R.id.buttonNine)
        btnDivision = findViewById(R.id.buttonDivision)
        btnMultiply = findViewById(R.id.buttonMultiply)
        btnMinus = findViewById(R.id.buttonMinus)
        btnPlus = findViewById(R.id.buttonPlus)
        btnClear = findViewById(R.id.buttonClear)
        btnResult = findViewById(R.id.buttonResult)
    }
}