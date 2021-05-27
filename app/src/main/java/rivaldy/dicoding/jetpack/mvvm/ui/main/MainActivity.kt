package rivaldy.dicoding.jetpack.mvvm.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.databinding.ActivityMainBinding
import rivaldy.dicoding.jetpack.mvvm.ui.movie.MovieFragment
import rivaldy.dicoding.jetpack.mvvm.ui.tv_show.TvShowFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val titles = arrayListOf(getString(R.string.movies), getString(R.string.tv_show))
        val fragments = arrayListOf(MovieFragment(), TvShowFragment())
        val viewPagerAdapter = ViewPagerAdapter(this, titles, fragments, supportFragmentManager)

        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}