package com.japanese.aki.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.japanese.aki.MainActivity
import com.japanese.aki.R
import com.japanese.aki.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        // Set the status bar color
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary)
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            var name = binding.tiPhone.editText!!.text.toString()
            var password = binding.tiPassword.editText!!.text.toString()
            if(name.isEmpty()){
                binding.tiPhone.error = "Mail is required"
                binding.tiPhone.requestFocus()
            }else if(password.isEmpty()){
                binding.tiPassword.error = "Password is required"
                binding.tiPassword.requestFocus()
            }else{
                //Login
                signIn(name,password)
            }
        }

        setContentView(binding.root)

    }

    fun signIn(mail: String, password: String){
        startActivity(Intent(this,MainActivity::class.java))
    }
}