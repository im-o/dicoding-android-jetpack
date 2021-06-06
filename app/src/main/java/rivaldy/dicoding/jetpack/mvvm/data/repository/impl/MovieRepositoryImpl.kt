package rivaldy.dicoding.jetpack.mvvm.data.repository.impl

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

    override suspend fun getMovies() = apiService.getMovies()
    override suspend fun getMovieDetail(movieId: Int) = apiService.getMovieDetail(movieId)
}