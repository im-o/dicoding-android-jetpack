package rivaldy.dicoding.jetpack.mvvm.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import rivaldy.dicoding.jetpack.mvvm.data.ResultData
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.MovieResponse
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieDummy
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieViewModel : ViewModel() {
    fun getMovies(): MutableList<MovieData> = MovieDummy.getDummyMovie()
}