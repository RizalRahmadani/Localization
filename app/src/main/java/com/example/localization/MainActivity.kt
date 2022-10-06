package com.example.localization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localization.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IN.setOnClickListener {
            setLocale("id")
        }

        binding.EN.setOnClickListener {
            setLocale("en")
        }
    }

    fun setLocale(lang: String?) {
        val myLocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}