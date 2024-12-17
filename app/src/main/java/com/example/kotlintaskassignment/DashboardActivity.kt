package com.example.kotlintaskassignment

DashboardActivity.kt


package com.example.assignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlintaskassignment.databinding.ActivityDashboard2Binding

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboard2Binding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDashboard2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // Safely getting the data passed via Intent
        val fullname: String = intent.getStringExtra("fullname").toString()
        val email: String = intent.getStringExtra("email").toString()
        val gender: String = intent.getStringExtra("gender").toString()
        val country: String = intent.getStringExtra("country").toString()
        val city: String = intent.getStringExtra("city").toString()

        // Display the received data
        binding.fullnameDisplay.text = "Full Name: ${fullname}"
        binding.emailDisplay.text = "Email: ${email}"
        binding.genderDisplay.text = "Gender: ${gender}"
        binding.countryDisplay.text = "Country: ${country}"
        binding.cityDisplay.text = "City: ${city}"




        // Handle window insets (for edge-to-edge UI)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
