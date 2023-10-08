package com.blueray.zoonni.fragment

import CarouselLayoutManager
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.blueray.sifsaf.helpers.CustomLinearSmoothScroller
import com.blueray.zoonni.R
import com.blueray.zoonni.activities.CartActivity
import com.blueray.zoonni.activities.HomeActivity
import com.blueray.zoonni.adapters.*
import com.blueray.zoonni.databinding.FragmentHomeBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var sliderAdapter : HomeSliderAdapter
    private lateinit var categoriesAdapter : HomeCategoriesAdapter
    private lateinit var recommendedForYouAdapter : HomeRecommendedForYouAdapter
    private lateinit var latestProductAdapter : LatestProductAdapter
    private lateinit var brandsAdapter : HomeBrandsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // init adapter app bar
        binding.includeTab.menuItem.setOnClickListener {
            (activity as HomeActivity).openDrawer()
        }
        binding.includeTab.cartIcon.setOnClickListener {
            startActivity(Intent(activity,CartActivity::class.java).apply{
                // todo add extras
            })
        }
        binding.includeTab.searchEt.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // init binding
        binding = FragmentHomeBinding.inflate(layoutInflater)

        // slider init
        initSliderAdapter()

        // start auto scroll
        lifecycleScope.launch {
            async { startAutoScroll() }
        }

        // init Categories adapter
        initCategoriesAdapter()

        // init recommended for you adapter
        initRecommendedForYouAdapter()

        //init latestProductAdapter
        initLatestProductAdapter()

        //init Brands Adapter
        initBrandsAdapter()

    }

    private fun initLatestProductAdapter() {
        // init adapter
        latestProductAdapter = LatestProductAdapter(listOf())
        binding.latestProductRv.adapter = latestProductAdapter
        binding.latestProductRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        latestProductAdapter.onItemClickListener{
            val dialog = ProductDetailsBottomSheetDialogFragment()
            dialog.show(childFragmentManager,"bottom")
        }
    }

    private fun initBrandsAdapter() {
        // init adapter
        brandsAdapter = HomeBrandsAdapter(listOf())
        binding.BrandsRv.adapter = brandsAdapter
        binding.BrandsRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        brandsAdapter.onItemClickListener{
            findNavController().navigate(R.id.productsFragment)
        }
    }

    private fun initRecommendedForYouAdapter() {
        // init adapter
        recommendedForYouAdapter = HomeRecommendedForYouAdapter(listOf())
        binding.recommendedForYouRv.adapter = recommendedForYouAdapter
        binding.recommendedForYouRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.offersRv.adapter = recommendedForYouAdapter
        binding.offersRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        recommendedForYouAdapter.onItemClickListener{
            val dialog = ProductDetailsBottomSheetDialogFragment()
            dialog.show(childFragmentManager,"bottom")
        }
    }

    private fun initCategoriesAdapter() {
        // init adapter
        categoriesAdapter = HomeCategoriesAdapter(listOf())
        binding.categoriesRv.adapter = categoriesAdapter
        binding.categoriesRv.layoutManager = GridLayoutManager(requireContext(),2,GridLayoutManager.HORIZONTAL,false)
        categoriesAdapter.onItemClickListener{
            findNavController().navigate(R.id.subCategoriesFragment)
        }
    }

    private fun initSliderAdapter() {
        // init adapter
        sliderAdapter = HomeSliderAdapter(listOf())
        binding.homeSlider.adapter = sliderAdapter
        binding.homeSlider.layoutManager = CarouselLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.summerSaleRv.adapter = sliderAdapter
        binding.summerSaleRv.layoutManager = CarouselLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)


    }

    // slider implementation
    private suspend fun startAutoScroll() {
        lifecycleScope.launch{

            delay(2000)
            val layoutManager = binding.homeSlider.layoutManager as CarouselLayoutManager
            val currentLocation = layoutManager.findFirstVisibleItemPosition()

            val itemCount = sliderAdapter.itemCount
            val nextPosition = (currentLocation + 1) % itemCount

            if(nextPosition == 0){
                startReverseAutoScroll()
                return@launch
            }

            val smoothScroller = CustomLinearSmoothScroller(requireContext())

            // Set the target position and start the smooth scroll
            smoothScroller.targetPosition = nextPosition
            layoutManager.startSmoothScroll(smoothScroller)
            // Call startAutoScroll recursively
            startAutoScroll()
        }
    }

    private suspend fun startReverseAutoScroll() {
        lifecycleScope.launch{
            delay(1500)
            val layoutManager = binding.homeSlider.layoutManager as CarouselLayoutManager
            val currentLocation = layoutManager.findFirstVisibleItemPosition()

            val nextPosition = currentLocation - 1

            if(currentLocation == 0){
                startAutoScroll()
                return@launch
            }

            val smoothScroller = CustomLinearSmoothScroller(requireContext())

            // Set the target position and start the smooth scroll
            smoothScroller.targetPosition = nextPosition
            layoutManager.startSmoothScroll(smoothScroller)

            // Call startAutoScroll recursively
            startReverseAutoScroll()
        }
    }


}