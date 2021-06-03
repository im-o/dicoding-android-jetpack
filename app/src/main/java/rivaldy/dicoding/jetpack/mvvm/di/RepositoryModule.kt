package rivaldy.dicoding.jetpack.mvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import rivaldy.dicoding.jetpack.mvvm.data.remote.ApiService
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.TvShowRepositoryImpl

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideMovieRepositoryImpl(apiService: ApiService) = MovieRepositoryImpl(apiService)

    @Provides
    fun provideTvShowRepositoryImpl(apiService: ApiService) = TvShowRepositoryImpl(apiService)
}