package rivaldy.dicoding.jetpack.mvvm.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import rivaldy.dicoding.jetpack.mvvm.data.local.db.AppDatabase
import rivaldy.dicoding.jetpack.mvvm.data.local.db.dao.MovieDao
import rivaldy.dicoding.jetpack.mvvm.data.local.db.dao.TvShowDao
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.DB_THE_MOVIE_DB
import javax.inject.Singleton

/**
 * Created by rivaldy on 28/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

@InstallIn(ActivityRetainedComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_THE_MOVIE_DB).build()
    }

    @Provides
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

    @Provides
    fun provideTvShowDao(appDatabase: AppDatabase): TvShowDao {
        return appDatabase.tvShowDao()
    }
}