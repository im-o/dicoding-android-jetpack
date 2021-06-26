package rivaldy.dicoding.jetpack.mvvm.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.mock
import rivaldy.dicoding.jetpack.mvvm.data.FakeDataUseCase
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieDummy
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.TvShowRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.utils.UtilLiveDataTest

/**
 * Created by rivaldy on 26/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

class DataUseCaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val movieRepository = mock(MovieRepositoryImpl::class.java)
    private val tvShowRepository = mock(TvShowRepositoryImpl::class.java)
    private val useCase = FakeDataUseCase(movieRepository, tvShowRepository)

    private val movieDummy = MovieDummy.getDummyMovie()
    private val movieIdDummy = movieDummy.results?.get(0)?.id ?: 0
    private val movieDetailDummy = MovieDummy.getDummyMovieDetail()

    private val tvShowDummy = MovieDummy.getDummyTvShow()
    private val tvShowIdDummy = tvShowDummy.results?.get(0)?.id ?: 0
    private val tvShowDetailDummy = MovieDummy.getDummyTvShowDetail()

    @Test
    fun getMovies() {
        doAnswer {
            (it.arguments[0] as MovieRepositoryImpl.OnGetMovieCallback).onGetMovie(movieDummy)
            null
        }.`when`(movieRepository).getMovies(any())

        val movieLiveData = UtilLiveDataTest.getValue(useCase.getMovies())
        verify(movieRepository).getMovies(any())
        assertNotNull(movieLiveData)
        assertEquals(movieDummy.results?.size, movieLiveData.results?.size)
    }

    @Test
    fun getTvShows() {
        doAnswer {
            (it.arguments[0] as TvShowRepositoryImpl.OnGetTvShowCallback).onGetTvShow(tvShowDummy)
            null
        }.`when`(tvShowRepository).getTvShows(any())

        val tvShowLiveData = UtilLiveDataTest.getValue(useCase.getTvShows())
        verify(tvShowRepository).getTvShows(any())
        assertNotNull(tvShowLiveData)
        assertEquals(tvShowDummy.results?.size, tvShowLiveData.results?.size)
    }

    @Test
    fun getMovieDetail() {
        doAnswer {
            (it.arguments[1] as MovieRepositoryImpl.OnGetMovieDetailCallback).onGetMovieDetail(movieDetailDummy)
            null
        }.`when`(movieRepository).getMovieDetail(eq(movieIdDummy), any())

        val movieDetailLiveData = UtilLiveDataTest.getValue(useCase.getMovieDetail(movieIdDummy))
        verify(movieRepository).getMovieDetail(eq(movieIdDummy), any())
        assertNotNull(movieDetailLiveData)
        assertEquals(movieDetailDummy.id, movieDetailLiveData.id)
    }

    @Test
    fun getTvShowDetail() {
        doAnswer {
            (it.arguments[1] as TvShowRepositoryImpl.OnGetTvShowDetailCallback).onGetTvShowDetail(tvShowDetailDummy)
            null
        }.`when`(tvShowRepository).getTvShowDetail(eq(tvShowIdDummy), any())

        val tvShowDetailLiveData = UtilLiveDataTest.getValue(useCase.getTvShowDetail(tvShowIdDummy))
        verify(tvShowRepository).getTvShowDetail(eq(tvShowIdDummy), any())
        assertNotNull(tvShowDetailLiveData)
        assertEquals(tvShowDetailDummy.id, tvShowDetailLiveData.id)
    }
}