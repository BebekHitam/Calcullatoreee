package com.example.kotlinonebutton

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalcViewModel: ViewModel() {
    private val plus = Plus()
    private val hitung = LogicHitung()
    var textA by mutableStateOf("")
        private set //setter only accessible dari view model
    var textB by mutableStateOf("")
        private set
    var textC by mutableStateOf("")
        private set
    var operators by mutableStateOf("")
        private set

    var activePosition by mutableStateOf(1)
        private set


    //disini assign
    private val _result = MutableStateFlow(0.0)
    private val _inputCalc = MutableStateFlow("")

    //stateflow, hot data, yang akan diobserve oleh UI
    //tetap gunakan val, dan jangan var
    val result = _result.asStateFlow()
    val inputCalc = _inputCalc.asStateFlow()

    fun onEqualClicked(a: Double, b: Double) {
        _result.value = plus.add(a, b)
    }

    fun onOperatorClick(operatorr: String) {
        operators = operatorr
        activePosition = 2

    }

    fun SwitchActiveField(){
        activePosition = if (activePosition == 1) 2 else 1
    }
    fun currentActivePosition(pos: Int){
        activePosition = pos
    }
    fun onNumClick(number: String) {

        if (activePosition == 1) {
            textA += number// Gabungkan string: "1" + "2" = "12"
        } else {
            textB += number
        }
    }
    fun onBackspace() {
        if (activePosition == 1) {
            if (textA.isNotEmpty()) {
                textA = textA.dropLast(1)
            }
        } else {
            if (textB.isNotEmpty()) {
                textB = textB.dropLast(1)
            }
        }
    }

    fun clear() {
        textA = "0"
        textB = "0"
        textC = "0"
        operators = ""
    }

    fun hitung() {
        val valA = textA.toDoubleOrNull() ?: 0.0
        val valB = textB.toDoubleOrNull() ?: 0.0
        if (operators.isNotEmpty()) {
            _result.value = when (operators) {
                "+" -> hitung.add(valA, valB)
                "-" -> hitung.decrement(valA, valB)
                "*" -> hitung.multiple(valA, valB)
                "/" -> hitung.division(valA, valB)
                else -> 0.0
            }
        }
    }







//    fun numericClicked(nuber: Integer){
//        _inputCalc.value =
//    }
}