package rivaldy.dicoding.jetpack.mvvm.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import rivaldy.dicoding.jetpack.mvvm.data.ResultData
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.detail.MovieDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.detail.TvShowDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieDummy
import rivaldy.dicoding.jetpack.mvvm.data.remote.ApiService
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class DetailMovieViewModel @ViewModelInject constructor(
    private val useCase: DataUseCase
) : ViewModel() {

//    private lateinit var movieId: String
//
//    fun setSelectedMovie(movieId: String) {
//        this.movieId = movieId
//    }
//
//    fun getDetailMovie(): MovieData {
//        lateinit var movie: MovieData
//        val movieData = MovieDummy.getDummyMovie()
//        for (movieItem in movieData) {
//            if (movieItem.movieId == movieId) {
//                movie = movieItem
//            }
//        }
//        return movie
//    }
//
//    fun getDetailTvShow(): MovieData {
//        lateinit var tvShow: MovieData
//        val tvShowData = MovieDummy.getDummyTvShow()
//        for (tvShowItem in tvShowData) {
//            if (tvShowItem.movieId == movieId) {
//                tvShow = tvShowItem
//            }
//        }
//        return tvShow
//    }

    fun getDetailMovieById(movieId: Int) : LiveData<ResultData<MovieDetailResponse>> {
        return liveData {
            emit(ResultData.Loading())
            emit(useCase.getMovieDetail(movieId))
        }
    }

    fun getDetailTvShowById(tvShowId: Int) : LiveData<ResultData<TvShowDetailResponse>> {
        return liveData {
            emit(ResultData.Loading())
            emit(useCase.getTvShowDetail(tvShowId))
        }
    }
}