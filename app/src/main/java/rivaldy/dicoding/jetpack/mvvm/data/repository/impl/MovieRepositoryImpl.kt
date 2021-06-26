package rivaldy.dicoding.jetpack.mvvm.data.repository.impl

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.MovieResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.detail.MovieDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.remote.ApiService
import rivaldy.dicoding.jetpack.mvvm.data.repository.MovieRepository
import javax.inject.Inject

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {

    override fun getMovies(callback: OnGetMovieCallback) {
        apiService.getMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                callback.onGetMovie(response.body() ?: return)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    override fun getMovieDetail(movieId: Int, callback: OnGetMovieDetailCallback) {
        apiService.getMovieDetail(movieId).enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                val result = response.body()
                callback.onGetMovieDetail(result ?: return)
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    interface OnGetMovieCallback {
        fun onGetMovie(movie: MovieResponse)
        fun onFailure(throwable: Throwable)
    }

    interface OnGetMovieDetailCallback {
        fun onGetMovieDetail(movieDetail: MovieDetailResponse)
        fun onFailure(throwable: Throwable)
    }
}