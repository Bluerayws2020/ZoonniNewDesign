package com.blueray.zoonni.activities

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.WindowCompat
import com.blueray.sifsaf.helpers.HelperUtils.getLang
import com.blueray.zoonni.helpers.ContextWrapper
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    // to save the context of the resources and save the language if destroyed
    override fun attachBaseContext(newBase: Context?) {
        val lang = getLang(newBase!!)
        val local = Locale(lang)
        val newContext = ContextWrapper.wrap(newBase, local)
        super.attachBaseContext(newContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        // set flags to full screen if you want to hid status bar
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
    }
}