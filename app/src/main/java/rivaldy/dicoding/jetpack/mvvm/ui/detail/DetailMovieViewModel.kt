package rivaldy.dicoding.jetpack.mvvm.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import rivaldy.dicoding.jetpack.mvvm.data.model.db.MovieEntity
import rivaldy.dicoding.jetpack.mvvm.data.model.db.TvShowEntity
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class DetailMovieViewModel @ViewModelInject constructor(
    private val useCase: DataUseCase
) : ViewModel() {

    /** API **/
    fun getDetailMovieById(movieId: Int) = useCase.getMovieDetail(movieId)
    fun getDetailTvShowById(tvShowId: Int) = useCase.getTvShowDetail(tvShowId)
    fun getFailureMessage() = useCase.failureMessage
    fun getIsLoadData() = useCase.onIsLoadData

    /** Local Storage - Room **/
    suspend fun insertMovie(movie: MovieEntity) {
        viewModelScope.launch {
            useCase.insertMovie(movie)
        }
    }

    suspend fun deleteMovie(movie: MovieEntity) {
        viewModelScope.launch {
            useCase.deleteMovie(movie)
        }
    }

    fun loadMovie() = useCase.loadMovie()
    fun getMovieById(movieId: Int) = useCase.getMovieById(movieId)

    suspend fun insertTvShow(tvShowEntity: TvShowEntity) {
        viewModelScope.launch {
            useCase.insertTvShow(tvShowEntity)
        }
    }

    suspend fun deleteTvShow(tvShowEntity: TvShowEntity) {
        viewModelScope.launch {
            useCase.deleteTvShow(tvShowEntity)
        }
    }

    fun loadTvShow() = useCase.loadTvShow()
    fun getTvShowById(tvShowId: Int) = useCase.getTvShowById(tvShowId)
}