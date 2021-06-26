package rivaldy.dicoding.jetpack.mvvm.data.repository

import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.TvShowRepositoryImpl

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

interface TvShowRepository {
    fun getTvShows(callback: TvShowRepositoryImpl.OnGetTvShowCallback)
    fun getTvShowDetail(tvShowId: Int, callback: TvShowRepositoryImpl.OnGetTvShowDetailCallback)
}