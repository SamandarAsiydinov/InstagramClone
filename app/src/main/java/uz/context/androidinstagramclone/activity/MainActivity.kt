package uz.context.androidinstagramclone.activity


import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import uz.context.androidinstagramclone.R
import uz.context.androidinstagramclone.adapter.ViewPagerAdapter
import uz.context.androidinstagramclone.databinding.ActivityMainBinding
import uz.context.androidinstagramclone.fragment.HomeFragment
import uz.context.androidinstagramclone.fragment.UploadFragment
import uz.context.androidinstagramclone.util.toast

/*
    It contains view pager with 5 fragments in MainActivity,
    and pages can be controlled by BottomNavigation
 */

class MainActivity : BaseActivity(), UploadFragment.UploadListener, HomeFragment.HomeListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var uploadFragment: UploadFragment
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private lateinit var binding: ActivityMainBinding
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    override fun scrollToHome() {
        index = 0
        scrollByIndex(index)
        toast("$index scroll to home")
    }

    override fun scrollToUpload() {
        index = 2
        scrollByIndex(index)
    }

    private fun scrollByIndex(index: Int) {
        binding.viewPager.currentItem = index
        binding.bottomNavigationView.menu.getItem(index).isChecked = true
    }

    private fun initViews() {
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPagerAdapter

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> binding.viewPager.currentItem = 0
                R.id.nav_search -> binding.viewPager.currentItem = 1
                R.id.nav_upload -> binding.viewPager.currentItem = 2
                R.id.nav_favorite -> binding.viewPager.currentItem = 3
                R.id.nav_profile -> binding.viewPager.currentItem = 4
            }
            true
        }
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                index = position
                binding.bottomNavigationView.menu.getItem(index).isChecked = true
            }
        })
        homeFragment = HomeFragment()
        uploadFragment = UploadFragment()
    }
}