package com.blueray.zoonni.fragment

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.blueray.zoonni.R
import com.blueray.zoonni.activities.CartActivity
import com.blueray.zoonni.activities.HomeActivity
import com.blueray.zoonni.adapters.LatestProductAdapter
import com.blueray.zoonni.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var binding : FragmentFavoriteBinding
    private lateinit var adapter : LatestProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // init binding
        binding = FragmentFavoriteBinding.inflate(layoutInflater)

        // init adapter
        initAdapter()
    }

    private fun initAdapter() {
        adapter = LatestProductAdapter(listOf())
        val lm = GridLayoutManager(requireContext(),3, GridLayoutManager.VERTICAL,false)
        binding.favoriteRv.layoutManager = lm
        binding.favoriteRv.adapter = adapter
        adapter.onItemClickListener{
            val dialog = ProductDetailsBottomSheetDialogFragment()
            dialog.show(childFragmentManager,"bottom")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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


}