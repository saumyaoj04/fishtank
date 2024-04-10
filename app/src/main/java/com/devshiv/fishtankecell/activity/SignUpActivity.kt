package com.devshiv.fishtankecell.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import carbon.widget.RelativeLayout
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.ActivityLoginBinding
import com.devshiv.fishtankecell.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()

        binding.signInTxt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.continueBtn.setOnClickListener {
            val email=binding.emailET.text.toString()
            val pass=binding.passwordET.text.toString()

            if(email.isNotEmpty()&&pass.isNotEmpty())
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val int=Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString() , Toast.LENGTH_SHORT).show()
                    }

                }else{
                Toast.makeText(this,"Empty fields are not allowed", Toast.LENGTH_SHORT)
            }
            startActivity(Intent(this, MainActivity::class.java))
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })
    }
}