package rivaldy.dicoding.jetpack.mvvm.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import rivaldy.dicoding.jetpack.mvvm.data.model.db.MovieEntity

/**
 * Created by rivaldy on 28/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Query("SELECT * FROM tbl_movie")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tbl_movie WHERE id = :movieId")
    fun getMovieById(movieId: Int): LiveData<MovieEntity>

    @Delete
    suspend fun deleteMovie(movie: MovieEntity)
}