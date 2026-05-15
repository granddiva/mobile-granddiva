package com.example.grand_mobile

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.grand_mobile.ui.RegisterGmailActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegisterGmail: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegisterGmail = findViewById(R.id.btnRegisterGmail)

        sharedPreferences = getSharedPreferences("USER_DATA", MODE_PRIVATE)

        btnLogin.setOnClickListener {

            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            val savedUsername = sharedPreferences.getString("username", "")
            val savedPassword = sharedPreferences.getString("password", "")

            if ((username == password && username.isNotEmpty()) ||
                (username == savedUsername && password == savedPassword && username.isNotEmpty())
            ) {

                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {

                MaterialAlertDialogBuilder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username atau Password salah")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        btnRegisterGmail.setOnClickListener {

            startActivity(Intent(this, RegisterGmailActivity::class.java))
        }
    }
}
