package rivaldy.dicoding.jetpack.mvvm.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class DetailMovieViewModel @ViewModelInject constructor(
    private val useCase: DataUseCase
) : ViewModel() {

    fun getDetailMovieById(movieId: Int) = useCase.getMovieDetail(movieId)
    fun getDetailTvShowById(tvShowId: Int) = useCase.getTvShowDetail(tvShowId)
    fun getFailureMessage() = useCase.failureMessage
    fun getIsLoadData() = useCase.onIsLoadData
}