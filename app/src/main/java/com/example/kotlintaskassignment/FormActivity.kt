package com.example.kotlintaskassignment

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlintaskassignment.databinding.ActivityFormBinding


class FormActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

  lateinit var binding: ActivityFormBinding
    var countries = arrayOf("Select Country","Nepal", "Canada", "Japan", "Russia", "Denmark", "India", "Sirlanka", "Egypt")
    var cities = arrayOf("Bhaktapur", "Bake", "Bardiya", "Britabod", "Bandipur", "Pokhara", "Pathivara", "Kathmandu", "Kritipur", "Kapilbastu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding: ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize AutoCompleteTextView for Cities
        val cityAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cities
        )
        binding.city.setAdapter(cityAdapter)
        binding.city.threshold = 1

        // Initialize Spinner for Countries
        val countryAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countries
        )


        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.country.adapter = countryAdapter
        binding.country.onItemSelectedListener = this

        // Submit button click listener
        binding.Submit.setOnClickListener {
            val username = binding.fullname.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val country = binding.country.selectedItem?.toString() ?: ""
            val city = binding.city.text.toString()
            val conditions = binding.conditions.isChecked

            // Validate inputs

            val selectGender = binding.radioGroup.checkedRadioButtonId
            val gender = when(selectGender){
                R.id.male -> "Male"
                R.id.female -> "Female"
                R.id.other -> "Other"
                else -> null
            }

            if (username.isEmpty()){
                binding.fullname.error = "Username cannot be empty"
            }else if(email.isEmpty()) {
                binding.email.error = "Email cannot be empty"
            }else if (password.isEmpty()) {
                binding.password.error = "Password cannot be empty"
            }else if (gender == null){
                Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show()
            }else if(country == "Select Country"){
                Toast.makeText(this,"Select a country",Toast.LENGTH_SHORT).show()
            }
            else if (country.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please select a country.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else if(city.isEmpty()) {
                binding.city.error = null
                Toast.makeText(this,
                    "Please select a city.",
                    Toast.LENGTH_SHORT)
                    .show()
            }else if(!conditions) {
                Toast.makeText(
                    this,
                    "Please agree to the terms & conditions.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                val intent = Intent(
                    this@FormActivity,
                    DashboardActivity::class.java
                )
                intent.putExtra("fullname",username)
                intent.putExtra("email",email)
                intent.putExtra("gender",gender)
                intent.putExtra("country",country)
                intent.putExtra("city",city)
                startActivity(intent)
                finish()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}