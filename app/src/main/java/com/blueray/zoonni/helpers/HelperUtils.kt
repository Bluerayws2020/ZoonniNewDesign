package com.blueray.sifsaf.helpers

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody


object HelperUtils {

    const val BASE_URL = "https://siyam.br-ws.com/"
    const val SHARED_PREF = "SIYAM_KEY"
    private const val UID_KEY = "UID"

    fun String.toStringRequestBody(): RequestBody {
        return this.toRequestBody("multipart/form-data".toMediaTypeOrNull())
    }

    fun getLang(mContext: Context?): String {
        val sharedPreferences = mContext?.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        return sharedPreferences?.getString("lang", "en")!!
    }

    fun getUID(mContext: Context?): String {
        val sharedPreferences = mContext?.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        return sharedPreferences?.getString("uid", "0")!!
    }

    fun isBranchSelected(mContext: Context?): Boolean {
        val sharedPreferences = mContext?.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        return sharedPreferences?.getInt("branch_id", 0) != 0
    }


    fun hideKeyBoard(activity: Activity) {
        //Find the currently focused view, so we can grab the correct window token from it.
        var view: View? = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        (activity.getSystemService(Activity.INPUT_METHOD_SERVICE)
                as InputMethodManager).hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun isNetWorkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
        return if (networkCapabilities != null) {
            when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            }
        } else false
    }


    @SuppressLint("HardwareIds")
    fun getAndroidID(mContext: Context?): String =
        Settings.Secure.getString(mContext?.contentResolver, Settings.Secure.ANDROID_ID)

    fun showMessage(context : Context, message : String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
    fun getUid(context: Context):String{
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE)
        return sharedPreferences.getString(UID_KEY,"1")!!
    }






}