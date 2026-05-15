package com.example.grand_mobile.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.grand_mobile.LoginActivity
import com.example.grand_mobile.R

class SuccessActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}