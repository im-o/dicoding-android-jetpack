package rivaldy.dicoding.jetpack.mvvm.ui.tv_show

import androidx.lifecycle.ViewModel
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieDummy
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class TvShowViewModel : ViewModel() {
    fun getTvShows(): MutableList<MovieData> = MovieDummy.getDummyTvShow()
}