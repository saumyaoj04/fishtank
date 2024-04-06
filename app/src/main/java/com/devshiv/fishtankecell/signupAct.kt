package com.devshiv.fishtankecell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import carbon.widget.RelativeLayout
import com.devshiv.fishtankecell.activity.MainActivity

class signupAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        (findViewById(R.id.signUpWithGoogle) as RelativeLayout).setOnClickListener {
            startActivity(Intent(this@signupAct, MainActivity::class.java))
        }
    }
}