package rivaldy.dicoding.jetpack.mvvm.data.repository.impl

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.TvShowResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.detail.TvShowDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.remote.ApiService
import rivaldy.dicoding.jetpack.mvvm.data.repository.TvShowRepository
import javax.inject.Inject

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

class TvShowRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TvShowRepository {

    override fun getTvShows(callback: OnGetTvShowCallback) {
        apiService.getTvShows().enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                callback.onGetTvShow(response.body() ?: return)
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    override fun getTvShowDetail(tvShowId: Int, callback: OnGetTvShowDetailCallback) {
        apiService.getTvShowDetail(tvShowId).enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(call: Call<TvShowDetailResponse>, response: Response<TvShowDetailResponse>) {
                val result = response.body()
                callback.onGetTvShowDetail(result ?: return)
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    interface OnGetTvShowCallback {
        fun onGetTvShow(tvShow: TvShowResponse)
        fun onFailure(throwable: Throwable)
    }

    interface OnGetTvShowDetailCallback {
        fun onGetTvShowDetail(tvShowDetail: TvShowDetailResponse)
        fun onFailure(throwable: Throwable)
    }
}