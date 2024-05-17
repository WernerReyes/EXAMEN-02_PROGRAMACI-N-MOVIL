package com.reyes.werner.examen_02_reyes_werner.ejercicio02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.reyes.werner.examen_02_reyes_werner.R
import com.reyes.werner.examen_02_reyes_werner.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeComponent()
    }

    fun observeComponent() {
        binding.btnRegister.setOnClickListener{
            if (isEmptyInputs()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                goDetailActivity()
            }
        }
    }

    fun goDetailActivity() {
        val fullname = binding.edtFullName.text.toString()
        val phone = binding.edtPhone.text.toString()
        val products = binding.edtProducts.text.toString()
        val city = binding.edtCity.text.toString()
        val address = binding.edtAddress.text.toString()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(FULL_NAME_KEY, fullname)
        intent.putExtra(PHONE_KEY, phone)
        intent.putExtra(PRODUCTS_KEY, products)
        intent.putExtra(CITY_KEY, city)
        intent.putExtra(ADDRESS_KEY, address)
        startActivity(intent)

    }

    fun isEmptyInputs(): Boolean {
        return binding.edtFullName.text.isEmpty() ||
                binding.edtPhone.text.isEmpty() ||
                binding.edtProducts.text.isEmpty() ||
                binding.edtCity.text.isEmpty() ||
                binding.edtAddress.text.isEmpty()
    }
}