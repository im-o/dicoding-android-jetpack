package rivaldy.dicoding.jetpack.mvvm.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.databinding.ActivityDetailMovieBinding
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.isVisible

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_MOVIE = "EXTRA_ID_MOVIE"
    }

    private lateinit var binding: ActivityDetailMovieBinding

    private val extraIdMovie: String? by lazy {
        intent.getStringExtra(EXTRA_ID_MOVIE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPrepare()
        initData()
    }

    private fun initPrepare() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initData() {
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]
        if (extraIdMovie != null) {
            viewModel.setSelectedMovie(extraIdMovie ?: "")
            viewModel.getDetailMovie()
            initView(viewModel.getDetailMovie())
        }
    }

    private fun initView(movie: MovieData) {
        binding.apply {
            val strInfo = "${movie.date} • ${movie.country} • ${movie.genre} • ${movie.duration}"
            val picasso = Picasso.get()
            picasso.setIndicatorsEnabled(true)
            picasso.load(movie.imgPath)
                .placeholder(R.drawable.ic_thumbnails)
                .error(R.drawable.ic_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                .into(movieImageIV, object : Callback {
                    override fun onSuccess() {
                        loadingPB.isVisible(false)
                    }

                    override fun onError(e: Exception?) {
                        loadingPB.isVisible(false)
                    }
                })

            movieTitleTV.text = movie.title
            titleTV.text = movie.title
            infoGenreTV.text = strInfo
            movieRateTV.text = movie.rate
            descriptionTV.text = movie.desc
        }
    }
}