package com.japanese.aki

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.japanese.aki.onBoarding.OnBoardingActivity

class SpashScreen : AppCompatActivity() {
    private lateinit var ncLogoImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash_screen)
        // Set the status bar color
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary)
        ncLogoImageView = findViewById(R.id.nc_logo_white)
        ncLogoImageView.alpha = 0f
        ncLogoImageView.animate().setDuration(2000).alpha(1f).withEndAction {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
            val i = Intent(this, OnBoardingActivity::class.java)
            startActivity(i)

        }
    }
}