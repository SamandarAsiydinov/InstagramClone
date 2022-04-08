package uz.context.androidinstagramclone.util

import android.util.Log

object Logger {
    private const val IS_TESTER = true
    fun d(tag: String, msg: String) {
        if (IS_TESTER) Log.d(tag,msg)
    }
}