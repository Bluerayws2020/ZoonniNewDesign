
package com.blueray.zoonni.activities

import android.content.Intent
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.blueray.zoonni.R
import com.blueray.zoonni.databinding.ActivityHomeBinding

class HomeActivity : InnerBaseActivity() {

    private lateinit var binding :ActivityHomeBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set up navigation
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
        NavigationUI.setupWithNavController(binding.navMenu, navController)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.categories ->{
                    navController.navigate(R.id.categoriesFragment)
                    true
                }
                R.id.deals->{
                    navController.navigate(R.id.offersProductsFragment)
                    true
                }
                R.id.favorite ->{
                    navController.navigate(R.id.favoriteFragment)
                    true
                }
                else->{
                    false
                }
            }
        }

        binding.navMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.myOrders ->{
                    startActivity(Intent(this,MyOrdersActivity::class.java))
                    true
                }
                R.id.favorite ->{
                    navController.navigate(R.id.favoriteFragment)
                    openDrawer()
                    binding.bottomNav.selectedItemId = R.id.favorite
                    true
                }
                R.id.accountSettings ->{
                    startActivity(Intent(this,MyAccountSettingsActivity::class.java))
                    true
                }
                R.id.notifications ->{
                    startActivity(Intent(this,NotificationActivity::class.java))
                    true
                }
                R.id.contactUs ->{
                    startActivity(Intent(this,ContactUsActivity::class.java))
                    true
                }
                R.id.changeLanguage ->{
                    // todo add design for chang lang
                    false
                }
                R.id.logout ->{
                    finish()
                    true
                }
                else ->{
                    false
                }
            }
        }

        binding.cartFab.setOnClickListener {
            startActivity(Intent(this,CartActivity::class.java).apply {
                // add extras
            })
        }


    }

    fun openDrawer() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else
            binding.drawerLayout.openDrawer(GravityCompat.START)
    }

}