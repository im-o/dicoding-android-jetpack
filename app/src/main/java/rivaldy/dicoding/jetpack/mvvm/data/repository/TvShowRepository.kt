package rivaldy.dicoding.jetpack.mvvm.data.repository

import rivaldy.dicoding.jetpack.mvvm.data.model.api.tv_show.TvShowResponse

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

interface TvShowRepository {
    suspend fun getTvShows(): TvShowResponse?
}