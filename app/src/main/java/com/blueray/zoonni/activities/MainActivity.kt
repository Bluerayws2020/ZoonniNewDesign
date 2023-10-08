package com.blueray.zoonni.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import com.blueray.sifsaf.helpers.ViewUtils.hide
import com.blueray.sifsaf.helpers.ViewUtils.show
import com.blueray.zoonni.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonsLayout.hide()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        MainScope().launch {
            delay(3000L)
            binding.buttonsLayout.show()
        }

        binding.signInBtn.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java).apply {
                // todo add extras
            })
        }
        binding.guestBtn.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java).apply {
                // todo add extras
            })
        }

    }
}