package uz.context.androidinstagramclone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import uz.context.androidinstagramclone.R
import uz.context.androidinstagramclone.databinding.ActivitySignInBinding
import uz.context.androidinstagramclone.util.toast

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
            callActivity(this,SignUpActivity(), false)
        }
        binding.etEmail.requestFocus()
        binding.bSignin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (isNotEmpty(email, password)) {
                callActivity(this,MainActivity(), true)
            } else {
                toast("Please enter some data")
            }
        }
    }
    private fun isNotEmpty(s1: String, s2: String): Boolean {
        return !(TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
    }
}


















