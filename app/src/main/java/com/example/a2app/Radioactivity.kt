package com.example.a2app

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Radioactivity : AppCompatActivity() {


    lateinit var moto : RadioButton
    lateinit var nokia : RadioButton
    lateinit var sony : RadioButton
    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radioactivity)
        moto = findViewById(R.id.radioMoto)
        nokia = findViewById(R.id.radioNokia)
        sony = findViewById(R.id.radioSony)
        image = findViewById(R.id.imageView)


        moto.setOnClickListener{
            image.setImageResource(R.drawable.moto)
        }

        nokia.setOnClickListener{
            image.setImageResource(R.drawable.nokia)
        }

        sony.setOnClickListener{
            image.setImageResource(R.drawable.sony)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}