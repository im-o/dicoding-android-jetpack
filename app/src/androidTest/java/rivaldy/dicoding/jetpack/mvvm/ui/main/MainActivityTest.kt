package rivaldy.dicoding.jetpack.mvvm.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieDummy
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.SAMPLE_POSITION
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.STR_TV_SHOW

/**
 * Created by rivaldy on 29/05/21
 * Find me on my Github -> https://github.com/im-o
 */

class MainActivityTest {
    private val movies = MovieDummy.getDummyMovie()
    private val tvShows = MovieDummy.getDummyTvShow()

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.movieListRV)).check(matches(isDisplayed()))
        onView(withId(R.id.movieListRV)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))
    }

    @Test
    fun loadDetailMovie() {
        val movie = movies[SAMPLE_POSITION]
        val strInfo = "${movie.date} • ${movie.country} • ${movie.genre} • ${movie.duration}"
        onView(withId(R.id.movieListRV)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(SAMPLE_POSITION, click()))
        onView(withId(R.id.titleTV)).check(matches(isDisplayed()))
        onView(withId(R.id.titleTV)).check(matches(withText(movie.title)))
        onView(withId(R.id.descriptionTV)).check(matches(isDisplayed()))
        onView(withId(R.id.descriptionTV)).check(matches(withText(movie.desc)))
        onView(withId(R.id.movieRateTV)).check(matches(isDisplayed()))
        onView(withId(R.id.movieRateTV)).check(matches(withText(movie.rate)))
        onView(withId(R.id.infoGenreTV)).check(matches(isDisplayed()))
        onView(withId(R.id.infoGenreTV)).check(matches(withText(strInfo)))
    }

    @Test
    fun loadTvShows() {
        onView(withText(STR_TV_SHOW)).perform(click())
        onView(withId(R.id.tvListRV)).check(matches(isDisplayed()))
        onView(withId(R.id.tvListRV)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows.size))
    }

    @Test
    fun loadDetailTvShow() {
        val tvShow = tvShows[SAMPLE_POSITION]
        val strInfo = "${tvShow.date} • ${tvShow.country} • ${tvShow.genre} • ${tvShow.duration}"
        onView(withText(STR_TV_SHOW)).perform(click())
        onView(withId(R.id.tvListRV)).check(matches(isDisplayed()))
        onView(withId(R.id.tvListRV)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(SAMPLE_POSITION, click()))
        onView(withId(R.id.titleTV)).check(matches(isDisplayed()))
        onView(withId(R.id.titleTV)).check(matches(withText(tvShow.title)))
        onView(withId(R.id.descriptionTV)).check(matches(isDisplayed()))
        onView(withId(R.id.descriptionTV)).check(matches(withText(tvShow.desc)))
        onView(withId(R.id.movieRateTV)).check(matches(isDisplayed()))
        onView(withId(R.id.movieRateTV)).check(matches(withText(tvShow.rate)))
        onView(withId(R.id.infoGenreTV)).check(matches(isDisplayed()))
        onView(withId(R.id.infoGenreTV)).check(matches(withText(strInfo)))
    }
}