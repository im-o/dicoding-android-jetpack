package rivaldy.dicoding.jetpack.mvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import rivaldy.dicoding.jetpack.mvvm.data.model.db.MovieEntity

/**
 * Created by rivaldy on 28/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

interface MovieLocalRepository {
    suspend fun insertMovie(movie: MovieEntity)
    suspend fun deleteMovie(movie: MovieEntity)
    fun loadMovie(): DataSource.Factory<Int, MovieEntity>
    fun getMovieById(movieId: Int): LiveData<MovieEntity>
}