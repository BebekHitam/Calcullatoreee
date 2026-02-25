package com.example.kotlinonebutton

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class KalkulatorViewModel : ViewModel() {

    private val plus = Plus()
    private val _result = MutableStateFlow("")
    val result: MutableStateFlow<Double> = MutableStateFlow(0.0)
    val inputCalc: MutableStateFlow<String> = MutableStateFlow("")

    fun onEqualClicked(a: Double, b: Double){
        val _result = plus.add(a, b)
        result.value = _result

    }

    fun numericClicked(number: String){
        val _numinput = number
        inputCalc.value = _numinput
    }

}