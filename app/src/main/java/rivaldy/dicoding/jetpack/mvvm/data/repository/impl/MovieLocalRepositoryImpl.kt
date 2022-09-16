package rivaldy.dicoding.jetpack.mvvm.data.repository.impl

import androidx.paging.DataSource
import rivaldy.dicoding.jetpack.mvvm.data.local.db.dao.MovieDao
import rivaldy.dicoding.jetpack.mvvm.data.model.db.MovieEntity
import rivaldy.dicoding.jetpack.mvvm.data.repository.MovieLocalRepository
import javax.inject.Inject

/**
 * Created by rivaldy on 28/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieLocalRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao
) : MovieLocalRepository {

    override suspend fun insertMovie(movie: MovieEntity) = movieDao.insertMovie(movie)
    override suspend fun deleteMovie(movie: MovieEntity) = movieDao.deleteMovie(movie)
    override fun loadMovie(): DataSource.Factory<Int, MovieEntity> = movieDao.getMovies()
    override fun getMovieById(movieId: Int) = movieDao.getMovieById(movieId)
}