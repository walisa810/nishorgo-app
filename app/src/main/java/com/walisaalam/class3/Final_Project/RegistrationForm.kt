package com.walisaalam.class3.Final_Project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.walisaalam.class3.R

class RegistrationForm : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etAge: EditText

    private var name = ""
    private var email = ""
    private var password = ""
    private var age = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_form)
        etName = findViewById<EditText>(R.id.etName)
        etEmail = findViewById<EditText>(R.id.etMail)
        etPassword = findViewById<EditText>(R.id.etPassword)
        etAge = findViewById<EditText>(R.id.etAge)

        savedInstanceState?.let{
            name = it.getString("etName").toString()
            email = it.getString("etEmail").toString()
            password = it.getString("etPassword").toString()
            age = it.getInt("etAge").toString()
        }
        etName.setText(name)
        etEmail.setText(email)
        etPassword.setText(password)
        etAge.setText(age)

        val button = findViewById<Button>(R.id.btnSubmit)
        button.setOnClickListener{
            if( name != "" && email != "" && password != "" && age != "")
                Toast.makeText(button.context,"Successful Registration!",Toast.LENGTH_LONG).show()
            else{
                Toast.makeText(button.context,"Unsuccessful Attempt!!",Toast.LENGTH_LONG).show()
            }
        }
    }
}