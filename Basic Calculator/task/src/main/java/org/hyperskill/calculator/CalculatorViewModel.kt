package org.hyperskill.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private var previousNumber = 0.0
    private var pendingOperation = "="
    private val result = MutableLiveData<String>()
    val getResult: LiveData<String>
        get() = result

    fun digitPressed(caption: String) {
        result.value = if ((result.value ?: "") == "0" && caption != ".") caption else (result.value ?: "") + caption
    }

    fun zeroPressed() {
        if ((result.value ?: "") != "0") digitPressed("0")
    }

    fun dotPressed() {
        if (!(result.value ?: "").contains(".")) digitPressed(".")
    }

    fun clearPressed() {
        result.value = ""
        previousNumber = 0.0
        pendingOperation = "="
    }

    fun subtractPressed() {
        if ((result.value ?: "").isEmpty()) result.value = "-" else operandPressed("-")
    }

    fun operandPressed(op: String) {
        val value = (result.value ?: "0").toDoubleOrNull() ?: 0.0

        when (pendingOperation) {
            "=" -> previousNumber = value
            "/" -> previousNumber = if (value == 0.0) Double.NaN else previousNumber / value
            "*" -> previousNumber *= value
            "-" -> previousNumber -= value
            "+" -> previousNumber += value
        }
        result.value = if (op == "=") previousNumber.toString() else ""
        pendingOperation = op
    }
}