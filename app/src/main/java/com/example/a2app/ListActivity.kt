package com.example.a2app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListActivity : AppCompatActivity() {
    lateinit var listView: ListView
    var contscts = arrayOf("Ram", "Shyam", "Hari", "Gita",
        "Ram", "Shyam", "Hari", "Gita",
        "Ram", "Shyam", "Hari", "Gita",
        "Ram", "Shyam", "Hari", "Gita",
        "Ram", "Shyam", "Hari", "Gita",)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        listView =findViewById(R.id.list)

        var adapter=ArrayAdapter(
            this@ListActivity,
            android.R.layout.simple_list_item_1,
            contscts
        )

        listView.adapter =adapter
        listView.setOnItemClickListener { parent, p1,position, l ->
            if(parent!= null){
                Toast.makeText(this@ListActivity,
                    parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show()
            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}