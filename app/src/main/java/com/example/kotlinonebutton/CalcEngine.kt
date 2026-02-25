package com.example.kotlinonebutton

class CalcEngine {
    fun calculate(a: Double, b: Double, operator: String): String {
        return when (operator) {
            "+" -> (a + b).toString()
            "-" -> (a - b).toString()
            "*" -> (a * b).toString()
            "/" -> if (b != 0.0) (a / b).toString() else "Err"
            else -> "0"
        }
    }
}