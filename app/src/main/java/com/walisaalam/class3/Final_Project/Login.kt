package com.walisaalam.class3.Final_Project

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.os.Message
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.walisaalam.class3.R
import com.walisaalam.class3.databinding.ActivityLogin2Binding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding

    private lateinit var sharedPref: SharedPreferences
    private lateinit var prefEditor: Editor
    private val prefName = "settings"
    private val keyEmail = "email"
    private val keyPassword = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initSharedPreference()
        binding.button.setOnClickListener {
            val email = binding.etMail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                showMessage("Please insert Email and Password")
            } else {

                if ( binding.cbRememberMe.isChecked) {
                    saveCredentials(email,password)
                    Toast.makeText(this, "Data Stored in the shared Preference", Toast.LENGTH_LONG).show()
                }
            }

        }
        binding.etMail.setText(getValueFromPref(keyEmail))
        binding.etPassword.setText(getValueFromPref(keyPassword))

    }
    private fun initSharedPreference(){
        sharedPref = getSharedPreferences(prefName, MODE_PRIVATE)
        prefEditor = sharedPref.edit()
    }
    private fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    private fun saveCredentials(email: String,password: String){
        prefEditor.putString(keyEmail, email)
        prefEditor.putString(keyPassword, password)
        prefEditor.commit()
    }
    private fun getValueFromPref(key: String): String{
        return sharedPref.getString(key,"")!!
    }
}