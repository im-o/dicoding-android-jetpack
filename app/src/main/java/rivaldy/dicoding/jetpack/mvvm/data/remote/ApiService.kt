package rivaldy.dicoding.jetpack.mvvm.data.remote

import retrofit2.http.GET
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.MovieResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.TvShowResponse

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovies(): MovieResponse

    @GET("discover/tv")
    suspend fun getTvShows(): TvShowResponse
}