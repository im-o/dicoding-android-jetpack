package rivaldy.dicoding.jetpack.mvvm.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import rivaldy.dicoding.jetpack.mvvm.data.local.db.dao.MovieDao
import rivaldy.dicoding.jetpack.mvvm.data.local.db.dao.TvShowDao
import rivaldy.dicoding.jetpack.mvvm.data.model.db.MovieEntity
import rivaldy.dicoding.jetpack.mvvm.data.model.db.TvShowEntity

/**
 * Created by rivaldy on 28/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

@Database(
    entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
}