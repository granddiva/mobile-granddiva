package com.example.grand_mobile.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.grand_mobile.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RegisterGmailActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_gmail2)

        etEmail = findViewById(R.id.etEmail)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {

            val email = etEmail.text.toString()

            when {

                email.isEmpty() -> {
                    showError("Email tidak boleh kosong")
                }

                !email.endsWith("@gmail.com") -> {
                    showError("Email harus menggunakan @gmail.com")
                }

                else -> {

                    val intent = Intent(this, RegisterActivity::class.java)
                    intent.putExtra("email", email)
                    startActivity(intent)
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