package com.reyes.werner.examen_02_reyes_werner

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.reyes.werner.examen_02_reyes_werner.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerClick()
    }

    private fun listenerClick() {
        binding.btnShow.setOnClickListener {
            showCard()
        }

        binding.btnHide.setOnClickListener {
            hideData()
        }
    }

    private fun showCard() {
        binding.cardView.visibility = View.VISIBLE
    }

    private fun hideData() {
        binding.cardView.visibility = View.GONE
    }
}