package rivaldy.dicoding.jetpack.mvvm.ui.movie

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by rivaldy on 29/05/21
 * Find me on my Github -> https://github.com/im-o
 */

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @get:Rule
//    val coroutinesTestRule = CoroutinesTestRule()
//
//    @Mock
//    private lateinit var fakeDataUseCase: DataUseCase
//
//    @Mock
//    private lateinit var movieObserver: Observer<ResultData<MovieResponse>>
//
//
////    private val movieRepository = moc
////    private val dataUseCase =
//
//    private lateinit var viewModel: MovieViewModel
//
//
//    @Before
//    fun setUp() {
//        viewModel = MovieViewModel(fakeDataUseCase)
////        runBlocking {
////            verify(fakeDataUseCase).getMovies()
////        }
//    }
//
//    //
//    @Test
//    fun `testGetMovies, observer notifiedMovie`() = coroutinesTestRule.testDispatcher.runBlockingTest {
//        val observer = mock<Observer<ResultData<MovieResponse>>>()
//        observer.runCatching {
//            print("DATA : $this")
//        }
//        viewModel.getMovies().observeForever(movieObserver)
//        verify(movieObserver).onChanged(
//            ResultData.Success(null)
//        )
//        viewModel.getMovies().removeObserver(movieObserver)
//
////        movies.observeForever {
////            print("INI DATA $it")
////        }
////        assertNotNull(movies)
////        assertEquals(SIZE_EXPECTED_10, movies.value)
//    }
}