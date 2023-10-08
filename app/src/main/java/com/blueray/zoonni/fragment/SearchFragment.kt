package com.blueray.zoonni.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blueray.zoonni.R
import com.blueray.zoonni.activities.CartActivity
import com.blueray.zoonni.activities.HomeActivity
import com.blueray.zoonni.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding:FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSearchBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // init adapter app bar
        binding.includeTab.menuItem.setImageResource(R.drawable.backspace)
        binding.includeTab.menuItem.setOnClickListener {
            (activity as HomeActivity).onBackPressed()
        }
        binding.includeTab.cartIcon.setOnClickListener {
            startActivity(Intent(activity, CartActivity::class.java).apply{
                // todo add extras
            })
        }
        return binding.root
    }

}