package rivaldy.dicoding.jetpack.mvvm.ui

import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.rules.TestWatcher

/**
 * Created by rivaldy on 07/06/21
 * Find me on my Github -> https://github.com/im-o
 **/
class CoroutinesTestRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher() {

}