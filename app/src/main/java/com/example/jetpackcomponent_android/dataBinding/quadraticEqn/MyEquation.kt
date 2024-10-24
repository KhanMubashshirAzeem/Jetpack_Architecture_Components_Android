package com.example.jetpackcomponent_android.dataBinding.quadraticEqn

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.jetpackcomponent_android.BR
import com.example.jetpackcomponent_android.databinding.ActivityQuadraticEquationBinding
import kotlin.math.sqrt

// Class for holding the logic of the quadratic equation solver using Kotlin and Data Binding.
class MyEquation(var binding: ActivityQuadraticEquationBinding) : BaseObservable() {

    @Bindable
    var a: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.a)
        }

    @Bindable
    var b: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.b)
        }

    @Bindable
    var c: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.c)
        }

    // Function that is triggered when the user clicks the button to solve the equation
    fun solverEquation(view: View) {
        // Convert the input strings to doubles
        val aVal = a.toDouble()
        val bVal = b.toDouble()
        val cVal = c.toDouble()

        // Calculate the Discriminant (b^2 - 4ac)
        val discriminant = (bVal * bVal) - (4 * aVal * cVal)

        // Declare variables to hold the solutions
        val x1: Double
        val x2: Double

        // If discriminant is greater than 0, we have two real roots
        if (discriminant > 0) {
            x1 = (-bVal + sqrt(discriminant)) / (2 * aVal)
            x2 = (-bVal - sqrt(discriminant)) / (2 * aVal)
            binding.resultText.text = "X1 = %.2f, X2 = %.2f".format(x1, x2)
        } else if (discriminant < 0) {
            // If discriminant is less than 0, we have no real roots, only complex roots
            binding.resultText.text = "No Real Roots (Complex Roots)"
        } else {
            // If discriminant equals 0, we have one real solution
            x1 = (-bVal / (2 * aVal))
            binding.resultText.text = "x = %.2f".format(x1)
        }
    }
}
