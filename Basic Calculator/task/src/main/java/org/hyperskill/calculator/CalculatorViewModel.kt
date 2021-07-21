package org.hyperskill.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
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
    }
}