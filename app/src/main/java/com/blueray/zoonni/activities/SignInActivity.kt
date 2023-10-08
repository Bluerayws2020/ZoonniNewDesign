package com.blueray.zoonni.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.view.WindowCompat
import com.blueray.zoonni.R
import com.blueray.zoonni.databinding.ActivitySignInBinding

class SignInActivity : BaseActivity() {

    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        binding.signupBtn.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }



    }
}