package com.example.jetpackcomponent_android.dataBinding.quadraticEqn

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.jetpackcomponent_android.R
import com.example.jetpackcomponent_android.databinding.ActivityQuadraticEquationBinding

// Main activity for solving quadratic equations using Kotlin and Data Binding.
class QuadraticEquationActivity : AppCompatActivity() {

    private lateinit var equationBinding: ActivityQuadraticEquationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display for the activity
        enableEdgeToEdge()

        // Set the content view using Data Binding
        equationBinding = DataBindingUtil.setContentView(this, R.layout.activity_quadratic_equation)

        // Apply window insets to avoid overlapping with system bars
        ViewCompat.setOnApplyWindowInsetsListener(equationBinding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Create an instance of MyEquation and bind it to the layout
        val myEquation = MyEquation(equationBinding)
        equationBinding.equation = myEquation
    }
}
