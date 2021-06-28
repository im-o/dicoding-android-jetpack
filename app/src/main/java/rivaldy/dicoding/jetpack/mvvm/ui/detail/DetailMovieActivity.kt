package rivaldy.dicoding.jetpack.mvvm.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.detail.MovieDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.detail.TvShowDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.DetailMovieTv
import rivaldy.dicoding.jetpack.mvvm.databinding.ActivityDetailMovieBinding
import rivaldy.dicoding.jetpack.mvvm.ui.movie.MovieFragment
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.BASE_IMAGE_URL
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.isVisible
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.myToast
import rivaldy.dicoding.jetpack.mvvm.utils.UtilFunctions.subStringComma

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    private val viewModel by viewModels<DetailMovieViewModel>()

    private val extraIdMovie: Int? by lazy {
        intent.getIntExtra(EXTRA_ID_MOVIE, 0)
    }

    private val extraTAG: String? by lazy {
        intent.getStringExtra(EXTRA_TAG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPrepare()
        initObservers()
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

    private fun initObservers() {
        if (extraIdMovie != null) {
            if (extraTAG != null) {
                if (extraTAG.equals(MovieFragment.TAG)) {
                    viewModel.getDetailMovieById(extraIdMovie ?: 0).observe(this, {
                        prepareMovie(it)
                        binding.layoutNSV.isVisible(it != null)
                        binding.noDataTV.isVisible(it == null)
                    })
                } else {
                    viewModel.getDetailTvShowById(extraIdMovie ?: 0).observe(this, {
                        prepareTvShow(it)
                        binding.layoutNSV.isVisible(it != null)
                        binding.noDataTV.isVisible(it == null)
                    })
                }
            }
        }

        viewModel.getFailureMessage().observe(this, {
            myToast(it.message.toString())
        })

        viewModel.getIsLoadData().observe(this, {
            binding.loadingSKV.isVisible(it)
        })
    }

    private fun prepareMovie(movie: MovieDetailResponse?) {
        val strCompanies = arrayListOf<String>()
        val strGenres = arrayListOf<String>()
        val strRunTime = getString(R.string.str_minutes, movie?.runtime?.toString())
        val strImgPath = BASE_IMAGE_URL + movie?.backdropPath
        for (i in (movie?.productionCountries?.indices ?: return)) strCompanies.add(movie.productionCountries?.get(i)?.iso31661.toString())
        for (i in (movie.genres?.indices ?: return)) strGenres.add(movie.genres?.get(i)?.name.toString())
        val strInfo = getString(R.string.str_info, movie.releaseDate, strCompanies.subStringComma(), strGenres.subStringComma(), strRunTime)
        val detailMovieTv = DetailMovieTv(movie.title, strInfo, movie.voteAverage.toString(), movie.overview, strImgPath)
        initView(detailMovieTv)
    }

    private fun prepareTvShow(tvShow: TvShowDetailResponse?) {
        val strCompanies = arrayListOf<String>()
        val strGenres = arrayListOf<String>()
        val strRunTime = getString(R.string.str_episodes, tvShow?.numberOfEpisodes.toString())
        val strImgPath = BASE_IMAGE_URL + tvShow?.backdropPath
        for (i in (tvShow?.productionCountries?.indices ?: return)) strCompanies.add(tvShow.productionCountries?.get(i)?.iso31661.toString())
        for (i in (tvShow.genres?.indices ?: return)) strGenres.add(tvShow.genres?.get(i)?.name.toString())
        val strInfo = getString(R.string.str_info, tvShow.firstAirDate, strCompanies.subStringComma(), strGenres.subStringComma(), strRunTime)
        val detailMovieTv = DetailMovieTv(tvShow.name, strInfo, tvShow.voteAverage.toString(), tvShow.overview, strImgPath)
        initView(detailMovieTv)
    }

    private fun initView(movieTv: DetailMovieTv) {
        binding.apply {
            val picasso = Picasso.get()
            picasso.setIndicatorsEnabled(true)
            picasso.load(movieTv.urlImage)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                .into(movieImageIV)

            movieTitleTV.text = movieTv.title ?: getString(R.string.no_detail)
            titleTV.text = movieTv.title ?: getString(R.string.no_detail)
            infoGenreTV.text = movieTv.genre
            movieRateTV.text = movieTv.rate.toString()
            descriptionTV.text = movieTv.desc ?: getString(R.string.no_detail)
        }
    }

    companion object {
        const val EXTRA_ID_MOVIE = "EXTRA_ID_MOVIE"
        const val EXTRA_TAG = "EXTRA_TAG"
    }
}