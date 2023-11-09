package com.example.midterm_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var etFullName = findViewById<EditText>(R.id.etFullName)
        var etUsername = findViewById<EditText>(R.id.etUsername)
        var etPassword = findViewById<EditText>(R.id.etPassword)
        var btnRegister = findViewById<Button>(R.id.btnRegister)
        var btnlog = findViewById<TextView>(R.id.logback_btn)

        btnRegister.setOnClickListener {
            val fullName = etFullName.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (fullName.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                // In a real app, you would save the user's data to a database.
                // For this example, we'll just display a toast message.
                val message = "Full Name: $fullName\nUsername: $username\nPassword: $password"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
        btnlog.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}