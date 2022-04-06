package uz.context.androidinstagramclone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.context.androidinstagramclone.R
import uz.context.androidinstagramclone.databinding.ActivitySignInBinding

class SignInActivity : BaseActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val TAG = SignInActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {
        binding.tvSignup.setOnClickListener {
            callActivity(this,MainActivity(), false)
        }
    }
}


















