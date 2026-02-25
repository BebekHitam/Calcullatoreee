package com.example.kotlinonebutton

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcVM : ViewModel() {
    private val engine = CalcEngine()

    var text1 by mutableStateOf("0")
        private set

    var text2 by mutableStateOf("0")
        private set

    var result by mutableStateOf("0")
        private set

    var operator by mutableStateOf("")
        private set

    var activePosition by mutableStateOf(1)
        private set

    fun onNumberClick(number: String) {
        when (activePosition) {
            1 -> text1 = if (text1 == "0") number else text1 + number
            2 -> text2 = if (text2 == "0") number else text2 + number
        }
        recalc()
    }

    fun onOperatorClick(op: String) {
        operator = op
        recalc()
    }

    fun switchActive() {
        activePosition = if (activePosition == 1) 2 else 1
    }

    fun clear() {
        text1 = "0"
        text2 = "0"
        result = "0"
        operator = ""
        activePosition = 1
    }

    private fun recalc() {
        if (operator.isNotEmpty()) {
            result = engine.calculate(
                text1.toDoubleOrNull() ?: 0.0,
                text2.toDoubleOrNull() ?: 0.0,
                operator
            )
        }
    }
}