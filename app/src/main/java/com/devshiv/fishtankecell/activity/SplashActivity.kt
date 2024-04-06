package com.devshiv.fishtankecell.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.devshiv.ecelldeskregistration.utils.SharedPrefsManager
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.navigationBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomLayout.post {
            YoYo.with(Techniques.SlideInUp)
                .duration(600)
                .repeat(0)
                .playOn(findViewById(R.id.bottomLayout))

            YoYo.with(Techniques.SlideInUp)
                .duration(700)
                .repeat(0)
                .playOn(findViewById(R.id.layout2))

            YoYo.with(Techniques.SlideInUp)
                .duration(900)
                .repeat(0)
                .playOn(findViewById(R.id.layout3))

            YoYo.with(Techniques.ZoomIn)
                .duration(900)
                .repeat(0)
                .playOn(findViewById(R.id.appIcon))
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (SharedPrefsManager.getLoginStatus(this)) {
                startActivity(Intent(this@SplashActivity, OnBoardActivity::class.java))
            } else {
                if (SharedPrefsManager.getOnBoardStatus(this)) {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                } else {
                    startActivity(Intent(this@SplashActivity, OnBoardActivity::class.java))
                }
            }
            finish()
        }, 1800)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })

    }

}