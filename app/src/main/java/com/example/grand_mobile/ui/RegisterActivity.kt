package com.example.grand_mobile.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.grand_mobile.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RegisterActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etEmail: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNama = findViewById(R.id.etNama)
        etEmail = findViewById(R.id.etEmail)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        sharedPreferences = getSharedPreferences("USER_DATA", MODE_PRIVATE)

        val email = intent.getStringExtra("email")

        etEmail.setText(email)
        etEmail.isEnabled = false

        btnRegister.setOnClickListener {

            val nama = etNama.text.toString()
            val emailValue = etEmail.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            when {

                nama.isEmpty() ||
                        emailValue.isEmpty() ||
                        username.isEmpty() ||
                        password.isEmpty() -> {

                    showError("Semua field wajib diisi")
                }

                password.length < 6 -> {

                    showError("Password minimal 6 karakter")
                }

                username.contains(" ") -> {

                    showError("Username tidak boleh mengandung spasi")
                }

                else -> {

                    val editor = sharedPreferences.edit()

                    editor.putString("nama", nama)
                    editor.putString("email", emailValue)
                    editor.putString("username", username)
                    editor.putString("password", password)

                    editor.apply()

                    startActivity(Intent(this, SuccessActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun showError(message: String) {

        MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}