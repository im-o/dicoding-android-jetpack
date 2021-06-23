package rivaldy.dicoding.jetpack.mvvm.ui.data

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.liveData
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import rivaldy.dicoding.jetpack.mvvm.data.ResultData
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.MovieResponse
import rivaldy.dicoding.jetpack.mvvm.data.remote.ApiService
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.TvShowRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.ui.CoroutinesTestRule

/**
 * Created by rivaldy on 07/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

class DataUseCaseTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule: CoroutinesTestRule = CoroutinesTestRule()

    val apiService = mock(ApiService::class.java)
    val movieRepositoryImpl = MovieRepositoryImpl(apiService)
    val tvShowRepositoryImpl = TvShowRepositoryImpl(apiService)
    val dataUseCase = FakeDataUseCase(movieRepositoryImpl, tvShowRepositoryImpl)

    @Test
    fun getMovies() {
//        runBlocking {
            liveData {
                dataUseCase.getMovies()
//                dataUseCase.getMovies().apply {
                    emit(ResultData.Loading())
                    emit(dataUseCase.getMovies())
                    print("tes")
//                }
            }
//        }
    }
}