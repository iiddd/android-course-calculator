package com.iiddd.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var btnZero: Button? = null
    private var btnOne: Button? = null
    private var btnTwo: Button? = null
    private var btnThree: Button? = null
    private var btnFour: Button? = null
    private var btnFive: Button? = null
    private var btnSix: Button? = null
    private var btnSeven: Button? = null
    private var btnEight: Button? = null
    private var btnNine: Button? = null
    private var btnDivision: Button? = null
    private var btnMultiply: Button? = null
    private var btnMinus: Button? = null
    private var btnPlus: Button? = null
    private var btnClear: Button? = null
    private var btnResult: Button? = null
    private var tvInput: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initKeyboard()
        tvInput = findViewById(R.id.tvInput)
        btnZero?.setOnClickListener {
            onDigit(btnZero as Button)
        }

        btnOne?.setOnClickListener {
            onDigit(btnOne as Button)
        }

        btnTwo?.setOnClickListener {
            onDigit(btnTwo as Button)
        }

        btnThree?.setOnClickListener {
            onDigit(btnThree as Button)
        }

        btnFour?.setOnClickListener {
            onDigit(btnFour as Button)
        }

        btnFive?.setOnClickListener {
            onDigit(btnFive as Button)
        }

        btnSix?.setOnClickListener {
            onDigit(btnSix as Button)
        }

        btnSeven?.setOnClickListener {
            onDigit(btnSeven as Button)
        }

        btnEight?.setOnClickListener {
            onDigit(btnEight as Button)
        }

        btnNine?.setOnClickListener {
            onDigit(btnNine as Button)
        }

        btnDivision?.setOnClickListener {
            onDigit(btnDivision as Button)
        }

        btnMultiply?.setOnClickListener {
            onDigit(btnMultiply as Button)
        }

        btnMinus?.setOnClickListener {
            onDigit(btnMinus as Button)
        }

        btnPlus?.setOnClickListener {
            onDigit(btnPlus as Button)
        }

        btnClear?.setOnClickListener {
            onClear()
        }

        btnResult?.setOnClickListener {
            onDigit(btnResult as Button)
        }
    }

    private fun onDigit(view: Button) {
        tvInput?.append((view).text)
    }

    private fun onClear() {
        tvInput?.text = null
    }

    private fun initKeyboard() {
        btnZero = findViewById(R.id.buttonZero)
        btnOne = findViewById(R.id.buttonOne)
        btnTwo = findViewById(R.id.buttonTwo)
        btnThree = findViewById(R.id.buttonThree)
        btnFour = findViewById(R.id.buttonFour)
        btnFive = findViewById(R.id.buttonFive)
        btnSix = findViewById(R.id.buttonSix)
        btnSeven = findViewById(R.id.buttonSeven)
        btnEight = findViewById(R.id.buttonEight)
        btnNine = findViewById(R.id.buttonNine)
        btnDivision = findViewById(R.id.buttonDivision)
        btnMultiply = findViewById(R.id.buttonMultiply)
        btnMinus = findViewById(R.id.buttonMinus)
        btnPlus = findViewById(R.id.buttonPlus)
        btnClear = findViewById(R.id.buttonClear)
        btnResult = findViewById(R.id.buttonResult)
    }
}