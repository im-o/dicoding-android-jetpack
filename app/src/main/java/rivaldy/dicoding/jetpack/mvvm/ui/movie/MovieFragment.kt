package rivaldy.dicoding.jetpack.mvvm.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.databinding.FragmentMovieBinding
import rivaldy.dicoding.jetpack.mvvm.ui.detail.DetailMovieActivity
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.isVisible
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.openActivity

class MovieFragment : Fragment() {

    companion object {
        val TAG = MovieFragment::class.java.name ?: ""
    }

    private lateinit var binding: FragmentMovieBinding

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
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
        val movies = viewModel.getMovies()
        binding.noDataTV.isVisible(movies.size <= 0)
        movieAdapter.setMovies(movies)
        with(binding.movieListRV) {
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    private fun setDataMovie(item: MovieData) {
        context?.openActivity(DetailMovieActivity::class.java) {
            putString(DetailMovieActivity.EXTRA_ID_MOVIE, item.movieId)
            putString(DetailMovieActivity.EXTRA_TAG, TAG)
        }
    }
}