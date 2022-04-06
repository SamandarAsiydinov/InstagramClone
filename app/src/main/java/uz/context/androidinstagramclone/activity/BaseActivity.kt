package uz.context.androidinstagramclone.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

// BaseActivity is parent for all activities

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    fun callActivity(fromActivity: Activity, toActivity: Activity, isFinish: Boolean) {
        startActivity(Intent(fromActivity, toActivity::class.java))
        if (isFinish)
            finish()
    }
}