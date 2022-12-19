package com.iiddd.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

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
    private var isLastNumeric: Boolean = true
    private var isInitialState: Boolean = true
    private var isLastDot: Boolean = false

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
            onEqual()
        }

        btnDot?.setOnClickListener {
            onDecimalPoint()
        }
    }

    private fun onDigit(view: View) {
        if (isInitialState) {
            tvInput?.text = ""
            isInitialState = false
        }
        tvInput?.append((view as Button).text)
        isLastNumeric = true
        isLastDot = false
    }

    private fun onClear() {
        tvInput?.text = "0"
        isInitialState = true
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

    private fun onEqual() {
        if (isLastNumeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""
            var splitValue: List<String>
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                val regex = """(\d*)([+,\-,*,/])(\d*)""".toRegex()
                val matchResult = regex.find(tvValue)
                when (val operator: String? = matchResult?.groups?.get(2)?.value) {
                    "+" -> {
                        splitValue = tvValue.split(operator)
                        val (firstArg, secondArg) = extractArguments(prefix, splitValue)
                        tvInput?.text =
                            formatResult((firstArg.toDouble() + secondArg.toDouble()).toString())
                    }
                    "-" -> {
                        splitValue = tvValue.split(operator)
                        val (firstArg, secondArg) = extractArguments(prefix, splitValue)
                        tvInput?.text =
                            formatResult((firstArg.toDouble() - secondArg.toDouble()).toString())
                    }
                    "*" -> {
                        splitValue = tvValue.split(operator)
                        val (firstArg, secondArg) = extractArguments(prefix, splitValue)
                        tvInput?.text =
                            formatResult((firstArg.toDouble() * secondArg.toDouble()).toString())
                    }
                    "/" -> {
                        splitValue = tvValue.split(operator)
                        val (firstArg, secondArg) = extractArguments(prefix, splitValue)
                        tvInput?.text =
                            formatResult((firstArg.toDouble() / secondArg.toDouble()).toString())
                    }
                }

            } catch (e: java.lang.ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun extractArguments(
        prefix: String,
        splitValue: List<String>
    ): Pair<String, String> {
        val firstArg = prefix + splitValue[0]
        val secondArg = splitValue[1]
        return Pair(firstArg, secondArg)
    }

    private fun formatResult(result: String): String {
        if (result.endsWith(".0")) {
            return result.split(".")[0]
        } else return result
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