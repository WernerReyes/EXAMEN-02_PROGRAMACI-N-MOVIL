package com.reyes.werner.examen_02_reyes_werner.ejercicio02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.reyes.werner.examen_02_reyes_werner.R
import com.reyes.werner.examen_02_reyes_werner.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerClick()
        intent.extras?.let {
            showData(it)
        }

    }
    private fun showData(paramsExtra: Bundle) {
        val fullname = paramsExtra.getString(FULL_NAME_KEY)
        val phone = paramsExtra.getString(PHONE_KEY)
        val products = paramsExtra.getString(PRODUCTS_KEY)
        val city = paramsExtra.getString(CITY_KEY)
        val address = paramsExtra.getString(ADDRESS_KEY)

        binding.tvFullName.text = fullname
        binding.tvPhone.text = phone
        binding.tvProducts.text = products
        binding.tvLocation.text = city + ", " + address
    }

    private fun listenerClick() {

        binding.btnPhone.setOnClickListener {
            goPhone()
        }
        binding.btnWhatsapp.setOnClickListener {
            goWhatsapp()
        }

        binding.btnMaps.setOnClickListener {
            goGoogleMaps()
        }


    }

    private fun goPhone() {
        val phoneNumber = binding.tvPhone.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+51$phoneNumber")
        startActivity(intent)
    }

    private fun goWhatsapp() {
        val phoneNumber = binding.tvPhone.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https:api.whatsapp.com/send?phone=$phoneNumber")
        startActivity(intent)
    }

    private fun goGoogleMaps() {
        val location = binding.tvLocation.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("geo:0,0?q=$location")
        startActivity(intent)
    }
}