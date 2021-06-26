package rivaldy.dicoding.jetpack.mvvm.data.repository

import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieRepositoryImpl

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

interface MovieRepository {
    fun getMovies(callback: MovieRepositoryImpl.OnGetMovieCallback)
    fun getMovieDetail(movieId: Int, callback: MovieRepositoryImpl.OnGetMovieDetailCallback)
}