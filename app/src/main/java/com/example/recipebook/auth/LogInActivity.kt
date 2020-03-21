package com.example.recipebook.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recipebook.MainActivity
import com.example.recipebook.R
import com.example.recipebook.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
private lateinit var binding:ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_log_in)

binding.buttonLogIn.setOnClickListener {
    startActivity(Intent(this,MainActivity::class.java))
}
    }
}
