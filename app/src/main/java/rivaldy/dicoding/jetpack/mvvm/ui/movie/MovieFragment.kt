package rivaldy.dicoding.jetpack.mvvm.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import rivaldy.dicoding.jetpack.mvvm.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity ?: return
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
        val movies = viewModel.getMovies()
        val movieAdapter = MovieAdapter {

        }
        movieAdapter.setMovies(movies)
        with(binding.movieListRV) {
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}