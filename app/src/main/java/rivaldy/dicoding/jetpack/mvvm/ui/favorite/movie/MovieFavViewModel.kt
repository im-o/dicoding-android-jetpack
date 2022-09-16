package rivaldy.dicoding.jetpack.mvvm.ui.favorite.movie

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase
import javax.inject.Inject

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

@HiltViewModel
class MovieFavViewModel @Inject constructor(
    private val useCase: DataUseCase
) : ViewModel() {

    fun loadMovie() = useCase.loadMovie()
}