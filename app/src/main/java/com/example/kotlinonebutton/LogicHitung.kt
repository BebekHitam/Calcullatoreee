package com.example.kotlinonebutton

class LogicHitung {
    //jangan diotak atik ini
    fun add(a: Double, b: Double): Double {
        return a + b
    }
    fun decrement(a: Double, b: Double): Double {
        return a - b
    }
    fun multiple(a: Double, b: Double): Double {
        return a * b
    }
    fun division(a: Double, b: Double): Double {
        if (b == 0.0) return 0.0
        return a / b
    }
}