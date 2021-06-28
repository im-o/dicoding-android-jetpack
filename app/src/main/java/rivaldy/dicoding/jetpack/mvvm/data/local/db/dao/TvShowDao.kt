package rivaldy.dicoding.jetpack.mvvm.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import rivaldy.dicoding.jetpack.mvvm.data.model.db.TvShowEntity

/**
 * Created by rivaldy on 28/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShow: TvShowEntity)

    @Query("SELECT * FROM tbl_tv_show")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tbl_tv_show WHERE id = :tvShowId")
    fun getMovieById(tvShowId: Int): LiveData<TvShowEntity>

    @Delete
    suspend fun deleteTvShow(tvShow: TvShowEntity)
}