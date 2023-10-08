package com.blueray.zoonni.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.blueray.zoonni.R
import com.blueray.zoonni.activities.CartActivity
import com.blueray.zoonni.activities.HomeActivity
import com.blueray.zoonni.adapters.CategoriesAdapter
import com.blueray.zoonni.databinding.CategoriesItemBinding
import com.blueray.zoonni.databinding.FragmentCategoriesBinding


class CategoriesFragment : Fragment() {

    private lateinit var binding : FragmentCategoriesBinding
    private lateinit var adapter :CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        // init adapter app bar
        binding.includeTab.menuItem.setOnClickListener {
            (activity as HomeActivity).openDrawer()
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
        binding = FragmentCategoriesBinding.inflate(layoutInflater)

        // init adapter
        initAdapter()

    }

    private fun initAdapter() {
        val lm = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        adapter = CategoriesAdapter(listOf())
        binding.categoriesRv.adapter = adapter
        binding.categoriesRv.layoutManager = lm
        adapter.onItemClickListener{
            findNavController().navigate(R.id.subCategoriesFragment)
        }
    }

}