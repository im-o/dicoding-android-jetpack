package rivaldy.dicoding.jetpack.mvvm.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import rivaldy.dicoding.jetpack.mvvm.data.ResultData
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.ResultMovie
import rivaldy.dicoding.jetpack.mvvm.databinding.FragmentMovieBinding
import rivaldy.dicoding.jetpack.mvvm.ui.detail.DetailMovieActivity
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.isVisible
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.openActivity

@AndroidEntryPoint
class MovieFragment : Fragment() {

    companion object {
        val TAG = MovieFragment::class.java.name ?: ""
    }

    private lateinit var binding: FragmentMovieBinding

    private val viewModel by viewModels<MovieViewModel>()

    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter { item -> setDataMovie(item) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity ?: return
        initData()
    }

    private fun initData() {
        viewModel.getMovies().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultData.Loading -> {
                    Log.e("TAG", "initData: Loading")
                }
                is ResultData.Success -> {
                    binding.noDataTV.isVisible(it.data?.results?.size ?: 0 <= 0)
                    movieAdapter.setMovies(it.data?.results)
                    with(binding.movieListRV) {
                        setHasFixedSize(true)
                        adapter = movieAdapter
                    }
                    Log.e("TAG", "initData: Success : ${it.data}")
                }
                is ResultData.Failed -> {
                    Log.e("TAG", "initData: Failed")
                }
                is ResultData.Exception -> {
                    Log.e("TAG", "initData: Exception",)
                }
            }
        })
    }

    private fun setDataMovie(item: ResultMovie) {
        context?.openActivity(DetailMovieActivity::class.java) {
//            putString(DetailMovieActivity.EXTRA_ID_MOVIE, item.movieId)
            putString(DetailMovieActivity.EXTRA_TAG, TAG)
        }
    }
}