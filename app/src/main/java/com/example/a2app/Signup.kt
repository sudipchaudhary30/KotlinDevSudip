package com.example.a2app

import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class Signup : AppCompatActivity() {

    lateinit var display: TextView
    lateinit var Displaygg: TextView
    lateinit var Fname: TextInputLayout
    lateinit var Lname: TextInputLayout
    lateinit var Password: TextInputLayout
    lateinit var Submit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        display = findViewById(R.id.Display)
        Displaygg = findViewById(R.id.DisplayGG)
        Fname = findViewById(R.id.FirstName)
        Lname = findViewById(R.id.LastName)
        Password = findViewById(R.id.Password)
        Submit =findViewById(R.id.ButtonS)

        Submit





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}