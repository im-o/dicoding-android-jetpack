package rivaldy.dicoding.jetpack.mvvm.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.databinding.FragmentTvShowBinding
import rivaldy.dicoding.jetpack.mvvm.ui.detail.DetailMovieActivity
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.openActivity

class TvShowFragment : Fragment() {

    companion object {
        val TAG = TvShowFragment::class.java.simpleName
    }

    private lateinit var binding: FragmentTvShowBinding

    private val tvShowAdapter: TvShowAdapter by lazy {
        TvShowAdapter { item -> setDataMovie(item) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity ?: return
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
        val tvShows = viewModel.getTvShows()
        tvShowAdapter.setTvShows(tvShows)
        with(binding.tvListRV) {
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

    private fun setDataMovie(item: MovieData) {
        context?.openActivity(DetailMovieActivity::class.java) {
            putString(DetailMovieActivity.EXTRA_ID_MOVIE, item.movieId)
            putString(DetailMovieActivity.EXTRA_TAG, TAG)
        }
    }
}