package rivaldy.dicoding.jetpack.mvvm.data.repository.impl

import rivaldy.dicoding.jetpack.mvvm.data.remote.ApiService
import rivaldy.dicoding.jetpack.mvvm.data.repository.TvShowRepository
import javax.inject.Inject

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

class TvShowRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TvShowRepository {

    override suspend fun getTvShows() = apiService.getTvShows()
}