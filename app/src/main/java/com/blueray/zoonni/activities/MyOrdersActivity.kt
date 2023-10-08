package com.blueray.zoonni.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.blueray.zoonni.R
import com.blueray.zoonni.adapters.LastOrdersAdapter
import com.blueray.zoonni.databinding.ActivityMyOrdersBinding

class MyOrdersActivity : InnerBaseActivity() {

    private lateinit var binding : ActivityMyOrdersBinding
    private lateinit var adapter : LastOrdersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyOrdersBinding.inflate(layoutInflater)
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
        binding.includeTab.title.text ="My Orders"

        // init adapter
        initAdapter()

    }

    private fun initAdapter() {
        adapter = LastOrdersAdapter(listOf())
        val lm = LinearLayoutManager(this)
        binding.lastOrdersRv.adapter = adapter
        binding.lastOrdersRv.layoutManager = lm
    }
}