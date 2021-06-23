package rivaldy.dicoding.jetpack.mvvm.utils

import androidx.test.espresso.idling.CountingIdlingResource

/**
 * Created by rivaldy on 20/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

object EspressoIdlingResource {
        private const val RESOURCE = "GLOBAL"
        val idlingResource = CountingIdlingResource(RESOURCE)

        fun increment() {
            idlingResource.increment()
        }

        fun decrement() {
            idlingResource.decrement()
        }
}