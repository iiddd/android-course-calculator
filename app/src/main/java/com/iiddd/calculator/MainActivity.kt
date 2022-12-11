package com.iiddd.calculator

import android.os.Bundle
import android.view.View
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
    private var btnDot: Button? = null
    private var btnResult: Button? = null
    private var tvInput: TextView? = null
    var isLastNumeric: Boolean = true
    var isLastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initKeyboard()
        tvInput = findViewById(R.id.tvInput)
        btnZero?.setOnClickListener {
            onDigit(btnZero!!)
        }

        btnOne?.setOnClickListener {
            onDigit(btnOne!!)
        }

        btnTwo?.setOnClickListener {
            onDigit(btnTwo!!)
        }

        btnThree?.setOnClickListener {
            onDigit(btnThree!!)
        }

        btnFour?.setOnClickListener {
            onDigit(btnFour!!)
        }

        btnFive?.setOnClickListener {
            onDigit(btnFive!!)
        }

        btnSix?.setOnClickListener {
            onDigit(btnSix!!)
        }

        btnSeven?.setOnClickListener {
            onDigit(btnSeven!!)
        }

        btnEight?.setOnClickListener {
            onDigit(btnEight!!)
        }

        btnNine?.setOnClickListener {
            onDigit(btnNine!!)
        }

        btnDivision?.setOnClickListener {
            onOperator(btnDivision!!)
        }

        btnMultiply?.setOnClickListener {
            onOperator(btnMultiply!!)
        }

        btnMinus?.setOnClickListener {
            onOperator(btnMinus!!)
        }

        btnPlus?.setOnClickListener {
            onOperator(btnPlus!!)
        }

        btnClear?.setOnClickListener {
            onClear()
        }

        btnResult?.setOnClickListener {
            onDigit(btnResult as Button)
        }

        btnDot?.setOnClickListener {
            onDecimalPoint()
        }
    }

    private fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        isLastNumeric = true
        isLastDot = false
    }

    private fun onClear() {
        tvInput?.text = "0"
    }

    private fun onDecimalPoint() {
        if (isLastNumeric && !isLastDot) {
            tvInput?.append(".")
            isLastNumeric = false
            isLastDot = true
        }
    }

    private fun onOperator(view: View) {
        tvInput?.text?.let {
            if (isLastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                isLastNumeric = false
                isLastDot = false
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        val operators = listOf(
            "/", "*", "+", "-"
        )
        return if (value.startsWith("-")) {
            false
        } else {
            val match = operators.filter {
                it in value
            }
            match.isNotEmpty()
        }
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
        btnDot = findViewById(R.id.buttonDot)
        btnResult = findViewById(R.id.buttonResult)
    }
}