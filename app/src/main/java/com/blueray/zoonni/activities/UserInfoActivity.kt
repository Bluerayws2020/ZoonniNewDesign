package com.blueray.zoonni.activities

import android.content.Intent
import android.os.Bundle
import com.blueray.zoonni.R
import com.blueray.zoonni.databinding.ActivityUserInfoBinding

class UserInfoActivity : InnerBaseActivity() {

    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        // init adapter app bar
//        binding.includeTab.back.setOnClickListener {
//            onBackPressed()
//        }
//        binding.includeTab.cartIcon.setOnClickListener {
//            startActivity(Intent(this,CartActivity::class.java).apply{
//                // todo add extras
//            })
//        }
//        binding.includeTab.title.text ="About Us"

    }
}