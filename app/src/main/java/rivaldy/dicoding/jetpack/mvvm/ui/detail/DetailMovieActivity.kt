package rivaldy.dicoding.jetpack.mvvm.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.databinding.ActivityDetailMovieBinding
import rivaldy.dicoding.jetpack.mvvm.ui.movie.MovieFragment

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID_MOVIE = "EXTRA_ID_MOVIE"
        const val EXTRA_TAG = "EXTRA_TAG"
    }

    private lateinit var binding: ActivityDetailMovieBinding

    private val extraIdMovie: String? by lazy {
        intent.getStringExtra(EXTRA_ID_MOVIE)
    }

    private val extraTAG: String? by lazy {
        intent.getStringExtra(EXTRA_TAG)
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
            if (extraTAG != null) {
                val movieData = if (extraTAG.equals(MovieFragment.TAG)) viewModel.getDetailMovie() else viewModel.getDetailTvShow()
                initView(movieData)
            }
        }
    }

    private fun initView(movie: MovieData?) {
        binding.apply {
            val strInfo = "${movie?.date} • ${movie?.country} • ${movie?.genre} • ${movie?.duration}"
            val strUrl = movie?.imgPath ?: 0
            val picasso = Picasso.get()
            picasso.setIndicatorsEnabled(true)
            picasso.load(strUrl)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                .into(movieImageIV)

            movieTitleTV.text = movie?.title ?: getString(R.string.no_detail)
            titleTV.text = movie?.title ?: getString(R.string.no_detail)
            infoGenreTV.text = strInfo
            movieRateTV.text = movie?.rate ?: getString(R.string.rate_0)
            descriptionTV.text = movie?.desc ?: getString(R.string.no_detail)
        }
    }
}