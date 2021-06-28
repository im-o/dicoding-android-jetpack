package rivaldy.dicoding.jetpack.mvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieLocalRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.TvShowLocalRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.TvShowRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

@InstallIn(ApplicationComponent::class)
@Module
object UseCaseModule {

//    @Provides
//    fun providesDataUseCase(
//        movieRepositoryImpl: MovieRepositoryImpl,
//        tvShowRepositoryImpl: TvShowRepositoryImpl
//    ): DataUseCase {
//        return DataUseCase(movieRepositoryImpl, tvShowRepositoryImpl)
//    }


    @Provides
    fun providesDataUseCase(
        movieRepositoryImpl: MovieRepositoryImpl,
        tvShowRepositoryImpl: TvShowRepositoryImpl,
        movieLocalRepositoryImpl: MovieLocalRepositoryImpl,
        tvShowLocalRepositoryImpl: TvShowLocalRepositoryImpl
    ): DataUseCase {
        return DataUseCase(movieRepositoryImpl, tvShowRepositoryImpl, movieLocalRepositoryImpl, tvShowLocalRepositoryImpl)
    }
}