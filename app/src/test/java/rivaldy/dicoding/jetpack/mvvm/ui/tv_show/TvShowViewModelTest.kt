package rivaldy.dicoding.jetpack.mvvm.ui.tv_show

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst

/**
 * Created by rivaldy on 29/05/21
 * Find me on my Github -> https://github.com/im-o
 */

class TvShowViewModelTest : TestCase() {

    private lateinit var viewModel: TvShowViewModel

    @Before
    override fun setUp() {
        super.setUp()
//        viewModel = TvShowViewModel()
    }

    @Test
    fun testGetTvShows() {
        val tvShows = viewModel.getTvShows()
        assertNotNull(tvShows)
        assertEquals(UtilConst.SIZE_EXPECTED_10, tvShows.size)
    }
}