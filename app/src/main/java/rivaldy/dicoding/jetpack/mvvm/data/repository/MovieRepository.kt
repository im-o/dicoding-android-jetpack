package rivaldy.dicoding.jetpack.mvvm.data.repository

import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.MovieResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.detail.MovieDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.TvShowResponse

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

interface MovieRepository {
    suspend fun getMovies(): MovieResponse?
    suspend fun getMovieDetail(movieId: Int) : MovieDetailResponse?
}