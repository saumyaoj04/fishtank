
package com.devshiv.fishtankecell.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.ActivityOnBoardBinding
import com.devshiv.fishtankecell.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })
    }
}