package rivaldy.dicoding.jetpack.mvvm.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieViewModel @ViewModelInject constructor(
    private val useCase: DataUseCase
): ViewModel() {

    fun getMovies() = useCase.getMovies()
    fun getFailureMessage() = useCase.failureMessage
    fun getIsLoadData() = useCase.onIsLoadData
}