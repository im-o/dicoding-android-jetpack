package rivaldy.dicoding.jetpack.mvvm.ui.favorite.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieFavViewModel @ViewModelInject constructor(
    private val useCase: DataUseCase
) : ViewModel() {

    fun loadMovie() = useCase.loadMovie()
}