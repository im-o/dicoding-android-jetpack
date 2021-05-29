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
        onView(withId(R.id.movieListRV)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(SAMPLE_POSITION, click()))
        onView(withId(R.id.titleTV)).check(matches(isDisplayed()))
        onView(withId(R.id.titleTV)).check(matches(withText(movies[SAMPLE_POSITION].title)))
        onView(withId(R.id.descriptionTV)).check(matches(isDisplayed()))
        onView(withId(R.id.descriptionTV)).check(matches(withText(movies[SAMPLE_POSITION].desc)))
        onView(withId(R.id.movieRateTV)).check(matches(isDisplayed()))
        onView(withId(R.id.movieRateTV)).check(matches(withText(movies[SAMPLE_POSITION].rate)))
    }

    @Test
    fun loadTvShows() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.tvListRV)).check(matches(isDisplayed()))
        onView(withId(R.id.tvListRV)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.tvListRV)).check(matches(isDisplayed()))
        onView(withId(R.id.tvListRV)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(SAMPLE_POSITION, click()))
        onView(withId(R.id.titleTV)).check(matches(isDisplayed()))
        onView(withId(R.id.titleTV)).check(matches(withText(tvShows[SAMPLE_POSITION].title)))
        onView(withId(R.id.descriptionTV)).check(matches(isDisplayed()))
        onView(withId(R.id.descriptionTV)).check(matches(withText(tvShows[SAMPLE_POSITION].desc)))
        onView(withId(R.id.movieRateTV)).check(matches(isDisplayed()))
        onView(withId(R.id.movieRateTV)).check(matches(withText(tvShows[SAMPLE_POSITION].rate)))
    }
}