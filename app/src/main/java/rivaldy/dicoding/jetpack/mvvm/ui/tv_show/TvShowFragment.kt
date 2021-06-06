package rivaldy.dicoding.jetpack.mvvm.ui.tv_show

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
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.ResultTv
import rivaldy.dicoding.jetpack.mvvm.databinding.FragmentTvShowBinding
import rivaldy.dicoding.jetpack.mvvm.ui.detail.DetailMovieActivity
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.isVisible
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.openActivity

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    companion object {
        val TAG = TvShowFragment::class.java.simpleName ?: ""
    }

    private lateinit var binding: FragmentTvShowBinding

    private val viewModel by viewModels<TvShowViewModel>()

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
        initData()
    }

    private fun initData() {
        viewModel.getTvShows().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultData.Loading -> {
                    Log.e("TAG", "initData: Loading")
                }
                is ResultData.Success -> {
                    binding.noDataTV.isVisible(it.data?.results?.size ?: 0 <= 0)
                    tvShowAdapter.setTvShows(it.data?.results)
                    with(binding.tvListRV) {
                        setHasFixedSize(true)
                        adapter = tvShowAdapter
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

    private fun setDataMovie(item: ResultTv) {
        context?.openActivity(DetailMovieActivity::class.java) {
            putInt(DetailMovieActivity.EXTRA_ID_MOVIE, item.id ?: 0)
            putString(DetailMovieActivity.EXTRA_TAG, TAG)
        }
    }
}