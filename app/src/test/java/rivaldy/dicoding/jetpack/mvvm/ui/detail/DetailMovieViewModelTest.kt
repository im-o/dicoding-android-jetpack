package rivaldy.dicoding.jetpack.mvvm.ui.detail

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieDummy

/**
 * Created by rivaldy on 29/05/21
 * Find me on my Github -> https://github.com/im-o
 */
class DetailMovieViewModelTest : TestCase() {

    private lateinit var viewModel: DetailMovieViewModel
    private val movieDummy = MovieDummy.getDummyMovie()[0]
    private val tvShowDummy = MovieDummy.getDummyTvShow()[0]
    private val movieId = movieDummy.movieId
    private val tvShowId = tvShowDummy.movieId

    @Before
    override fun setUp() {
        super.setUp()
        viewModel = DetailMovieViewModel()
    }

    @Test
    fun testGetDetailMovie() {
        viewModel.setSelectedMovie(movieId)
        val movie = viewModel.getDetailMovie()
        assertNotNull(movie)
        assertEquals(movieDummy, movie)
        assertEquals(movieDummy.title, movie.title)
        assertEquals(movieDummy.date, movie.date)
        assertEquals(movieDummy.desc, movie.desc)
        assertEquals(movieDummy.duration, movie.duration)
        assertEquals(movieDummy.imgPath, movie.imgPath)
        assertEquals(movieDummy.genre, movie.genre)
        assertEquals(movieDummy.rate, movie.rate)
    }

    @Test
    fun testGetDetailTvShow() {
        viewModel.setSelectedMovie(tvShowId)
        val tvShow = viewModel.getDetailTvShow()
        assertNotNull(tvShow)
        assertEquals(tvShowDummy, tvShow)
        assertEquals(tvShowDummy.title, tvShow.title)
        assertEquals(tvShowDummy.date, tvShow.date)
        assertEquals(tvShowDummy.desc, tvShow.desc)
        assertEquals(tvShowDummy.duration, tvShow.duration)
        assertEquals(tvShowDummy.imgPath, tvShow.imgPath)
        assertEquals(tvShowDummy.genre, tvShow.genre)
        assertEquals(tvShowDummy.rate, tvShow.rate)
    }
}