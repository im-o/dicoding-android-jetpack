package rivaldy.dicoding.jetpack.mvvm.ui.detail

import androidx.lifecycle.ViewModel
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieDummy

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getDetailMovie(): MovieData {
        lateinit var movie: MovieData
        val movieData = MovieDummy.getDummyMovie()
        for (movieItem in movieData) {
            if (movieItem.movieId == movieId) {
                movie = movieItem
            }
        }
        return movie
    }

    fun getDetailTvShow(): MovieData {
        lateinit var tvShow: MovieData
        val tvShowData = MovieDummy.getDummyTvShow()
        for (tvShowItem in tvShowData) {
            if (tvShowItem.movieId == movieId) {
                tvShow = tvShowItem
            }
        }
        return tvShow
    }
}