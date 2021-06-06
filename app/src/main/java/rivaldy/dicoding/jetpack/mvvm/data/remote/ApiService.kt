package rivaldy.dicoding.jetpack.mvvm.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.MovieResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.detail.MovieDetailResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.TvShowResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.detail.TvShowDetailResponse

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovies(): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): MovieDetailResponse

    @GET("discover/tv")
    suspend fun getTvShows(): TvShowResponse

    @GET("tv/{tv_id}")
    suspend fun getTvShowDetail(@Path("tv_id") tvShowId: Int): TvShowDetailResponse
}