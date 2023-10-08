package com.blueray.zoonni.fragment

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.blueray.zoonni.R
import com.blueray.zoonni.activities.CartActivity
import com.blueray.zoonni.activities.HomeActivity
import com.blueray.zoonni.adapters.CategoriesAdapter
import com.blueray.zoonni.databinding.FragmentSubCatigoriesBinding


class SubCategoriesFragment : Fragment() {

    private lateinit var binding : FragmentSubCatigoriesBinding
    private lateinit var adapter : CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // init adapter app bar
        binding.includeTab.back.setOnClickListener {
            (activity as HomeActivity).onBackPressed()
        }
        binding.includeTab.cartIcon.setOnClickListener {
            startActivity(Intent(activity, CartActivity::class.java).apply{
                // todo add extras
            })
        }
        binding.includeTab.title.text = "Categories"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // init binding
        binding = FragmentSubCatigoriesBinding.inflate(layoutInflater)

        // init adapter
        initAdapter()

    }

    private fun initAdapter() {
        adapter = CategoriesAdapter(listOf())
        val lm = GridLayoutManager(requireContext(),3)
        binding.categoryRv.adapter = adapter
        binding.categoryRv.layoutManager = lm
        adapter.onItemClickListener{
            findNavController().navigate(R.id.productsFragment)
        }
    }


}