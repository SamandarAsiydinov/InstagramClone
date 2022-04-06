package uz.context.androidinstagramclone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import uz.context.androidinstagramclone.R

// In SplashActivity, user can visit to SignInActivity or MainActivity

class SplashActivity : BaseActivity() {

    private val TAG = SplashActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        )

        initViews()

    }

    private fun initViews() {
        val countDownTimer = object : CountDownTimer(1000, 1300) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                callActivity(this@SplashActivity, SignInActivity(), true)
            }
        }
        countDownTimer.start()
    }
}