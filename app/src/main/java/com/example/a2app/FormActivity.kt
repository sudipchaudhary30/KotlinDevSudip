package com.example.a2app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity : AppCompatActivity() {


    lateinit var name: EditText
    lateinit var  button: Button
    lateinit var  display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)

        name =findViewById(R.id.editName)
        button =findViewById(R.id.buttonSubmit)
        display =findViewById(R.id.country)

        button.setOnClickListener{
            var data : String = name.text.toString()

            display.text = data
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.city)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}