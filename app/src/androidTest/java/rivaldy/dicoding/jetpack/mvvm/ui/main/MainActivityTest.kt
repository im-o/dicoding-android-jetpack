package rivaldy.dicoding.jetpack.mvvm.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.remote.ApiService
import rivaldy.dicoding.jetpack.mvvm.data.repository.impl.MovieRepositoryImpl
import rivaldy.dicoding.jetpack.mvvm.usecase.DataUseCase
import rivaldy.dicoding.jetpack.mvvm.utils.EspressoIdlingResource
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.SAMPLE_MOVIE_ID
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.SAMPLE_POSITION
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.SAMPLE_TV_SHOW_ID
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.STR_TV_SHOW
import javax.inject.Inject

/**
 * Created by rivaldy on 29/05/21
 * Find me on my Github -> https://github.com/im-o
 */

@HiltAndroidTest
class MainActivityTest {
//    private val movies = MovieDummy.getDummyMovie()
//    private val tvShows = MovieDummy.getDummyTvShow()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var useCase: DataUseCase

    @Inject
    lateinit var movieRepo: MovieRepositoryImpl

    @Before
    fun setUp() {
        hiltRule.inject()
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testLoadMovies() = runBlockingTest {
        launch {
            val movies = movieRepo.getMovies().results
            onView(withId(R.id.movieListRV)).check(matches(isDisplayed()))
            onView(withId(R.id.movieListRV)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    movies?.size ?: return@launch
                )
            )
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testLoadDetailMovie() = runBlockingTest {
        launch {
            val movie = apiService.getMovieDetail(SAMPLE_MOVIE_ID)
//            val strInfo = "${movie.date} • ${movie.country} • ${movie.genre} • ${movie.duration}"
            onView(withId(R.id.movieListRV)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(SAMPLE_POSITION, click()))
            onView(withId(R.id.titleTV)).check(matches(isDisplayed()))
            onView(withId(R.id.titleTV)).check(matches(withText(movie.title)))
            onView(withId(R.id.descriptionTV)).check(matches(isDisplayed()))
            onView(withId(R.id.descriptionTV)).check(matches(withText(movie.overview)))
            onView(withId(R.id.movieRateTV)).check(matches(isDisplayed()))
            onView(withId(R.id.movieRateTV)).check(matches(withText(movie.voteAverage.toString())))
            onView(withId(R.id.infoGenreTV)).check(matches(isDisplayed()))
//            onView(withId(R.id.infoGenreTV)).check(matches(withText(strInfo)))
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testLoadTvShows() = runBlockingTest {
        launch {
            val tvShows = apiService.getTvShows().results
            onView(withText(STR_TV_SHOW)).perform(click())
            onView(withId(R.id.tvListRV)).check(matches(isDisplayed()))
            onView(withId(R.id.tvListRV)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows?.size ?: return@launch))
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testDetailTvShow() = runBlockingTest {
        launch {
            val tvShow = apiService.getTvShowDetail(SAMPLE_TV_SHOW_ID)
            //val strInfo = "${tvShow.date} • ${tvShow.country} • ${tvShow.genre} • ${tvShow.duration}"
            onView(withText(STR_TV_SHOW)).perform(click())
            onView(withId(R.id.tvListRV)).check(matches(isDisplayed()))
            onView(withId(R.id.tvListRV)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(SAMPLE_POSITION, click()))
            onView(withId(R.id.titleTV)).check(matches(isDisplayed()))
            onView(withId(R.id.titleTV)).check(matches(withText(tvShow.name)))
            onView(withId(R.id.descriptionTV)).check(matches(isDisplayed()))
            onView(withId(R.id.descriptionTV)).check(matches(withText(tvShow.overview)))
            onView(withId(R.id.movieRateTV)).check(matches(isDisplayed()))
            onView(withId(R.id.movieRateTV)).check(matches(withText(tvShow.voteAverage.toString())))
            onView(withId(R.id.infoGenreTV)).check(matches(isDisplayed()))
            //onView(withId(R.id.infoGenreTV)).check(matches(withText(strInfo)))
        }
    }
}
