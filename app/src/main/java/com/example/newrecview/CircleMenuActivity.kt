package com.example.newrecview

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.newrecview.databinding.ActivityCircleMenuBinding

class CircleMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCircleMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCircleMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    fun init() {
        binding.circularMenu
            .setMainMenu(
                Color.parseColor("#FFFFFF"),
                R.drawable.ic_logo_green_small,
                R.drawable.ic_baseline_clear_24
            )
            .addSubMenu(Color.parseColor("#FFFFFF"), R.drawable.ic_fast_food)
            .addSubMenu(Color.parseColor("#FFFFFF"), R.drawable.ic_groceries)
            .addSubMenu(Color.parseColor("#FFFFFF"), R.drawable.ic_liquor)
            .addSubMenu(Color.parseColor("#FFFFFF"), R.drawable.ic_github)
            .addSubMenu(Color.parseColor("#FFFFFF"), R.drawable.ic_medicine)
            .addSubMenu(Color.parseColor("#FFFFFF"), R.drawable.ic_shawarma)
            .setOnMenuSelectedListener {

                if (it in 0..6) {
                    Handler().postDelayed({
                        startActivity(Intent(this,MainActivity::class.java))
                        }, 1000)

                }
            }

    }

}


