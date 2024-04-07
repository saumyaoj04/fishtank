package com.devshiv.fishtankecell.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import carbon.widget.RelativeLayout
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.ActivityLoginBinding
import com.devshiv.fishtankecell.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInTxt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.continueBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })
    }
}