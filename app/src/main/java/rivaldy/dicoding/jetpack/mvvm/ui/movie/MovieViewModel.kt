package rivaldy.dicoding.jetpack.mvvm.ui.movie

import androidx.lifecycle.ViewModel
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieDummy
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieViewModel: ViewModel() {
    fun getMovies(): MutableList<MovieData> = MovieDummy.getDummyMovie()
}