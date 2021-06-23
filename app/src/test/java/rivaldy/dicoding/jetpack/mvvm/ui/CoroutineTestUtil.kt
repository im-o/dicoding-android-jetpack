package rivaldy.dicoding.jetpack.mvvm.ui

import kotlinx.coroutines.CompletableDeferred

/**
 * Created by rivaldy on 07/06/21
 * Find me on my Github -> https://github.com/im-o
 **/
class CoroutineTestUtil {
    companion object {
        fun <T> T.toDeferred() = CompletableDeferred(this)
    }
}