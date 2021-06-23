package rivaldy.dicoding.jetpack.mvvm.ui.data

import rivaldy.dicoding.jetpack.mvvm.data.ResultData
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.MovieResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.detail.MovieDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.TvShowResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.detail.TvShowDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.TvShowRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase
import javax.inject.Inject

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

class FakeDataUseCase @Inject constructor(
    private val movieRepositoryImpl: MovieRepositoryImpl,
    private val tvShowRepositoryImpl: TvShowRepositoryImpl
) {

    suspend fun getMovies(): ResultData<MovieResponse> {
        val movieResponse = movieRepositoryImpl.getMovies()
        return if (movieResponse.page != null) {
            ResultData.Success(movieResponse)
        } else {
            ResultData.Failed(movieResponse.toString())
        }
    }

    suspend fun getTvShows(): ResultData<TvShowResponse> {
        val tvShowResponse = tvShowRepositoryImpl.getTvShows()
        return if (tvShowResponse.page != null) {
            ResultData.Success(tvShowResponse)
        } else {
            ResultData.Failed(tvShowResponse.toString())
        }
    }

    suspend fun getMovieDetail(movieId: Int): ResultData<MovieDetailResponse> {
        val movieResponse = movieRepositoryImpl.getMovieDetail(movieId)
        return if (movieResponse.id != null) {
            ResultData.Success(movieResponse)
        } else {
            ResultData.Failed(movieResponse.toString())
        }
    }

    suspend fun getTvShowDetail(tvShowId: Int): ResultData<TvShowDetailResponse> {
        val tvShowResponse = tvShowRepositoryImpl.getTvShowDetail(tvShowId)
        return if (tvShowResponse.id != null) {
            ResultData.Success(tvShowResponse)
        } else {
            ResultData.Failed(tvShowResponse.toString())
        }
    }
}