package com.example.midterm_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var etLoginUsername = findViewById<EditText>(R.id.etUsr)
        var etLoginPassword = findViewById<EditText>(R.id.etPass)
        var btnLogin = findViewById<Button>(R.id.login_btn)
        var btnreg = findViewById<TextView>(R.id.reg_btn)

        btnLogin.setOnClickListener {
            val username = etLoginUsername.text.toString()
            val password = etLoginPassword.text.toString()
            val intent = Intent(this, fHome::class.java)
            Log.d("usr", "text: " + etLoginUsername.text.toString())
            intent.putExtra("key1", etLoginUsername.text.toString())
            startActivity(intent)

            // In a real app, you would perform actual authentication here.
            // For this example, we'll check for a simple hardcoded username and password.
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Authentication successful, you can navigate to another activity.
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, fHome::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login Failed. Please check your credentials.", Toast.LENGTH_SHORT).show()
            }
        }
        btnreg.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}