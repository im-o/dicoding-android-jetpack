package rivaldy.dicoding.jetpack.mvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import rivaldy.dicoding.jetpack.mvvm.data.model.db.TvShowEntity

/**
 * Created by rivaldy on 28/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

interface TvShowLocalRepository {
    suspend fun insertTvShow(tvShow: TvShowEntity)
    suspend fun deleteTvShow(tvShow: TvShowEntity)
    fun loadTvShow(): DataSource.Factory<Int, TvShowEntity>
    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity>
}