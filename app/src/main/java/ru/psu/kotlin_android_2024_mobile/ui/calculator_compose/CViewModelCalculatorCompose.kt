package ru.psu.kotlin_android_2024_mobile.ui.calculator_compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CViewModelCalculatorCompose : ViewModel(){
    var op1 by mutableStateOf("")
        private set

    var op2 by mutableStateOf("")
        private set

    var result by mutableStateOf("")
        private set

    fun updateOperand1(input: String) {
        op1 = input
    }

    fun updateOperand2(input: String) {
        op2 = input
    }

    fun onButtonPlusClick() {
        result = (op1.toDouble()+op2.toDouble()).toString()
    }

    fun onButtonMinusClick() {
        result = (op1.toDouble()-op2.toDouble()).toString()
    }



}