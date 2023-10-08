package com.blueray.zoonni.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.blueray.sifsaf.helpers.ViewUtils.hide
import com.blueray.zoonni.R
import com.blueray.zoonni.adapters.CartItemAdapter
import com.blueray.zoonni.adapters.TotalAdapter
import com.blueray.zoonni.databinding.ActivityCartBinding

class CartActivity : InnerBaseActivity() {

    private lateinit var binding : ActivityCartBinding
    private lateinit var cartItemAdapter : CartItemAdapter
    private lateinit var totalItemAdapter : TotalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // init adapter app bar
        binding.includeTab.back.setOnClickListener {
            onBackPressed()
        }
        binding.includeTab.cartIcon.hide()
        binding.includeTab.title.text ="Cart"

        //init adapters
        initCartAdapter()
        initTotalAdapter()

    }

    private fun initTotalAdapter() {
        totalItemAdapter = TotalAdapter(listOf())
        val lm = LinearLayoutManager(this)
        binding.totalRv.adapter = totalItemAdapter
        binding.totalRv.layoutManager = lm
    }

    private fun initCartAdapter() {
        cartItemAdapter = CartItemAdapter(listOf())
        val lm = LinearLayoutManager(this)
        binding.cartItemRv.adapter = cartItemAdapter
        binding.cartItemRv.layoutManager = lm
    }
}