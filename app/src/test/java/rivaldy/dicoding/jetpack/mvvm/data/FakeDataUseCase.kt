package rivaldy.dicoding.jetpack.mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.MovieResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.detail.MovieDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.TvShowResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.detail.TvShowDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.TvShowRepositoryImpl

/**
 * Created by rivaldy on 26/06/21
 * Find me on my Github -> https://github.com/im-o
 **/
class FakeDataUseCase(
    private val movieRepositoryImpl: MovieRepositoryImpl,
    private val tvShowRepositoryImpl: TvShowRepositoryImpl
) {
    val failureMessage = MutableLiveData<Throwable>()
    val onIsLoadData = MutableLiveData<Boolean>()

    fun getMovies(): LiveData<MovieResponse> {
        onIsLoadData.postValue(true)
        val movieLiveData = MutableLiveData<MovieResponse>()
        movieRepositoryImpl.getMovies(object : MovieRepositoryImpl.OnGetMovieCallback {
            override fun onGetMovie(movie: MovieResponse) {
                movieLiveData.postValue(movie)
                onIsLoadData.postValue(false)
            }

            override fun onFailure(throwable: Throwable) {
                failureMessage.postValue(throwable)
                onIsLoadData.postValue(false)
            }
        })
        return movieLiveData
    }

    fun getMovieDetail(movieId: Int): LiveData<MovieDetailResponse> {
        onIsLoadData.postValue(true)
        val movieDetailLiveData = MutableLiveData<MovieDetailResponse>()
        movieRepositoryImpl.getMovieDetail(movieId, object : MovieRepositoryImpl.OnGetMovieDetailCallback {
            override fun onGetMovieDetail(movieDetail: MovieDetailResponse) {
                movieDetailLiveData.postValue(movieDetail)
                onIsLoadData.postValue(false)
            }

            override fun onFailure(throwable: Throwable) {
                failureMessage.postValue(throwable)
                onIsLoadData.postValue(false)
            }
        })
        return movieDetailLiveData
    }

    fun getTvShows(): LiveData<TvShowResponse> {
        onIsLoadData.postValue(true)
        val tvShowsLiveData = MutableLiveData<TvShowResponse>()
        tvShowRepositoryImpl.getTvShows(object : TvShowRepositoryImpl.OnGetTvShowCallback {
            override fun onGetTvShow(tvShow: TvShowResponse) {
                tvShowsLiveData.postValue(tvShow)
                onIsLoadData.postValue(false)
            }

            override fun onFailure(throwable: Throwable) {
                failureMessage.postValue(throwable)
                onIsLoadData.postValue(false)
            }
        })
        return tvShowsLiveData
    }

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowDetailResponse> {
        onIsLoadData.postValue(true)
        val tvShowDetailLiveData = MutableLiveData<TvShowDetailResponse>()
        tvShowRepositoryImpl.getTvShowDetail(tvShowId, object : TvShowRepositoryImpl.OnGetTvShowDetailCallback {
            override fun onGetTvShowDetail(tvShowDetail: TvShowDetailResponse) {
                tvShowDetailLiveData.postValue(tvShowDetail)
                onIsLoadData.postValue(false)
            }

            override fun onFailure(throwable: Throwable) {
                failureMessage.postValue(throwable)
                onIsLoadData.postValue(false)
            }
        })
        return tvShowDetailLiveData
    }
}