package uz.context.androidinstagramclone.util

import android.app.Activity
import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.context.androidinstagramclone.model.ScreenSize


object Utils {
    @Suppress("DEPRECATION")
    fun screenSize(context: Context): ScreenSize {
        val displayMetrics = DisplayMetrics()
        val windowManager = context.getSystemService(WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val deviceWidth = displayMetrics.widthPixels
        val deviceHeight = displayMetrics.heightPixels
        return ScreenSize(deviceWidth, deviceHeight)
    }
    fun log(tag: String, msg: String) {
        Log.d(tag, msg)
    }
}

fun Activity.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(text: String) {
    Toast.makeText(this.requireContext(), text, Toast.LENGTH_SHORT).show()
}