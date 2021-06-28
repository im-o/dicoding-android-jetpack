package rivaldy.dicoding.jetpack.mvvm.ui.favorite.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.ResultTv
import rivaldy.dicoding.jetpack.mvvm.databinding.FragmentTvShowBinding
import rivaldy.dicoding.jetpack.mvvm.ui.detail.DetailMovieActivity
import rivaldy.dicoding.jetpack.mvvm.ui.tv_show.TvShowFragment
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.isVisible
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.openActivity
import rivaldy.dicoding.jetpack.mvvm.utils.UtilFunctions.loge

@AndroidEntryPoint
class TvShowFavFragment : Fragment() {
    private lateinit var binding: FragmentTvShowBinding
    private val viewModel by viewModels<TvShowFavViewModel>()
    private val tvShowFavAdapter: TvShowFavAdapter by lazy {
        TvShowFavAdapter { item -> setDataMovie(item) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity ?: return
        initObserver()
    }

    private fun initObserver() {
        viewModel.getTvShows().observe(viewLifecycleOwner, {
            binding.noDataTV.isVisible(it.results?.size ?: 0 <= 0)
            tvShowFavAdapter.setTvShows(it.results)
            with(binding.tvListRV) {
                setHasFixedSize(true)
                adapter = tvShowFavAdapter
            }
        })

        viewModel.getFailureMessage().observe(viewLifecycleOwner, {
            loge(it.message.toString())
        })

        viewModel.getIsLoadData().observe(viewLifecycleOwner, {
            binding.loadingSKV.isVisible(it)
        })
    }

    private fun setDataMovie(item: ResultTv) {
        context?.openActivity(DetailMovieActivity::class.java) {
            putInt(DetailMovieActivity.EXTRA_ID_MOVIE, item.id ?: 0)
            putString(DetailMovieActivity.EXTRA_TAG, TAG)
        }
    }

    companion object {
        val TAG = TvShowFragment::class.java.simpleName ?: ""
    }
}