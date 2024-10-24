package com.example.jetpackcomponent_android.dataBinding

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.example.jetpackcomponent_android.dataBinding.quadraticEqn.QuadraticEquationActivity

class ButtonClickHandlers(private val context: Context) {

    fun displayToastMsg(view: View) {
        Toast.makeText(context, "You clicked the button", Toast.LENGTH_SHORT).show()

        // Create an Intent to start QuadraticEquationActivity
        val intent = Intent(context, QuadraticEquationActivity::class.java)

        // Start the activity
        context.startActivity(intent)
    }
}
