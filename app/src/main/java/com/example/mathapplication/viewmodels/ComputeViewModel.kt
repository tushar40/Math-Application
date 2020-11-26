package com.example.mathapplication.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mathapplication.utils.LiveEvent
import com.example.mathlibrary.MathOps

class ComputeViewModel: ViewModel() {

    /**
     * Property Variables
     */

    var variable1 = ObservableField<String>("")
    var variable2 = ObservableField<String>("")
    var result = ObservableField<String>("")
    val errorString = MutableLiveData<LiveEvent<String>>()
    val resultComputed = MutableLiveData<LiveEvent<Boolean>>()
    private val mathOps = MathOps()
    private val resultText = "Result= "

    /**
     * Member functions
     */

    fun add() {
        val a = variable1.get()?.toDoubleOrNull()
        val b = variable2.get()?.toDoubleOrNull()

        if (isNull(a, b))
            return

        result.set("$resultText${mathOps.add(a!!, b!!)}")
        resultComputed.postValue(LiveEvent(true))
    }

    fun subtract() {
        val a = variable1.get()?.toDoubleOrNull()
        val b = variable2.get()?.toDoubleOrNull()

        if (isNull(a, b))
            return

        result.set("$resultText${mathOps.subtract(a!!, b!!)}")
        resultComputed.postValue(LiveEvent(true))
    }

    fun reset() {
        variable2.set("")
        variable1.set("")
    }

    private fun isNull(a: Number?, b: Number?): Boolean {
        if (a == null && b == null) {
            errorString.postValue(LiveEvent("Variable1 and Variable2 are null"))
            return true
        }

        if (a == null) {
            errorString.postValue(LiveEvent("Variable1 is null"))
            return true
        }

        if (b == null) {
            errorString.postValue(LiveEvent("Variable2 is null"))
            return true
        }

        return false
    }
}