package uz.context.androidinstagramclone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import uz.context.androidinstagramclone.R
import uz.context.androidinstagramclone.databinding.ActivitySignUpBinding
import uz.context.androidinstagramclone.util.toast

class SignUpActivity : BaseActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val TAG = SignUpActivity::class.java.simpleName.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {
        binding.etFullname.requestFocus()
        binding.bSignup.setOnClickListener {
            val fullName = binding.etFullname.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (isNotEmpty(fullName, email, password)) {
                callActivity(this, MainActivity(), true)
            } else {
                toast("Please enter some data")
            }
        }
        binding.tvSignin.setOnClickListener {
            finish()
        }
    }

    private fun isNotEmpty(s1: String, s2: String, s3: String): Boolean {
        return !(TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3))
    }
}