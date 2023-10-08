package com.blueray.zoonni.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blueray.zoonni.R
import com.blueray.zoonni.databinding.ActivityAboutUsBinding

class AboutUsActivity : InnerBaseActivity() {

    private lateinit var binding : ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // init adapter app bar
        binding.includeTab.back.setOnClickListener {
            onBackPressed()
        }
        binding.includeTab.cartIcon.setOnClickListener {
            startActivity(Intent(this,CartActivity::class.java).apply{
                // todo add extras
            })
        }
        binding.includeTab.title.text ="About Us"
    }
}