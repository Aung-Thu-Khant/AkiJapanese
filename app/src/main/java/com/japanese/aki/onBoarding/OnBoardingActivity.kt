package com.japanese.aki.onBoarding

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.japanese.aki.MainActivity
import com.japanese.aki.R
import com.japanese.aki.adapter.OnBoardingAdapter
import com.japanese.aki.auth.Login

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var skipCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        skipCountTextView = findViewById(R.id.skipCount)

        // Set the status bar color
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = OnBoardingAdapter(this)

        TabLayoutMediator(findViewById(R.id.tabLayout), viewPager) { _, _ -> }.attach()

        // Countdown timer for 5 seconds
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                skipCountTextView.text = "Skip ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                val intent = Intent(this@OnBoardingActivity, Login::class.java)
                startActivity(intent)
                finish()
            }
        }.start()

        skipCountTextView.setOnClickListener {
            val intent = Intent(this@OnBoardingActivity, Login::class.java)
            startActivity(intent)
            finish()
        }

    }
}