package com.devshiv.fishtankecell.activity

import android.content.ContentProviderClient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.ActivityLoginBinding
import com.devshiv.fishtankecell.databinding.ActivitySplashBinding
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {


    lateinit var binding: ActivityLoginBinding
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var googleSignInClient:GoogleSignInAccount
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()
        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.))
        binding.signUpTxt.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))

        }
        binding.button.setOnClickListener {
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
                Toast.makeText(this,"Empty fields are not allowed",Toast.LENGTH_SHORT)
            }

        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })

    }
}