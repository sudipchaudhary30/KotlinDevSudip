package com.example.a2app

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner: Spinner
    lateinit var  textview: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var date: EditText

    var countries = arrayOf(
        "Nepal", "China", "Bhutan", "Pakistan", "Canada", "Australia", "India"
    )

    var cities = arrayOf("kathmandu", "Bhaktapur", "Lalitpur", "Kritipur", "kanchanpur")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup2)






        spinner = findViewById(R.id.Spinner)
        textview = findViewById(R.id.country)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        date =findViewById(R.id.Date)
        date.isClickable = true
        date.isFocusable = false


        date.setOnClickListener{
            loadCalender()
        }

        val autoAdapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_list_item_1,cities
        )
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold = 1




        val adapter = ArrayAdapter(
            this@SignupActivity,
            android.R.layout.simple_list_item_1,
            countries
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_list_item_1
        )

        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.city)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalender() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dialog = DatePickerDialog(
            this@SignupActivity,
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->

                date.setText("$year/${month+1}/$day")
            }, year, month, day
        )

        dialog.show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        if(parent != null){
            textview.text = "You have selected: ${parent.getItemAtPosition(position).toString()}"


        }


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}