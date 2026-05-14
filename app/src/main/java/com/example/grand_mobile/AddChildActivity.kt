package com.example.grand_mobile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.grand_mobile.databinding.ActivityAddChildBinding

class AddChildActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddChildBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddChildBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar sebagai ActionBar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.add_child)

        binding.btnSave.setOnClickListener {
            validateAndSave()
        }
    }

    private fun validateAndSave() {
        val name = binding.etName.text.toString()
        val parent = binding.etParent.text.toString()
        val gender = if (binding.rbMale.isChecked) "Laki-laki" else "Perempuan"

        if (name.isEmpty() || parent.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_empty_fields), Toast.LENGTH_SHORT).show()
        } else {
            showConfirmationDialog(name, parent, gender)
        }
    }

    private fun showConfirmationDialog(name: String, parent: String, gender: String) {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Simpan")
            .setMessage("Apakah data $name ($gender) sudah benar?")
            .setPositiveButton("Ya") { _, _ ->
                Toast.makeText(this, getString(R.string.success_save), Toast.LENGTH_LONG).show()
                finish()
            }
            .setNegativeButton("Tidak", null)
            .show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
