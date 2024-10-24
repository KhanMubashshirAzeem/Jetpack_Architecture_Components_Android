package com.example.jetpackcomponent_android.dataBinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.jetpackcomponent_android.R
import com.example.jetpackcomponent_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        setContentView(R.layout.activity_main)
//          Use DataBindingUtil to set the content View with data binding

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Accessing Binding Views
        var v1 = Vehicle()
        v1.name = "Mercedes"
        v1.modelYear = "2024"
        binding.myVehicle = v1

//        binding.button.setOnClickListener {
//            Toast.makeText(this, "you clicked the button", Toast.LENGTH_SHORT).show()
//        }
//        We will handle the button functionality in other class
        binding.clickHandler = ButtonClickHandlers(this)


    }
}