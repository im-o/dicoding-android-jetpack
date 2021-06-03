package rivaldy.dicoding.jetpack.mvvm.data

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

sealed class ResultData<out T> {
    data class Success<out T>(val data: T? = null): ResultData<T>()
    data class Loading(val nothing: Nothing? = null): ResultData<Nothing>()
    data class Failed(val message: String? = null): ResultData<Nothing>()
    data class Exception(val message: String? = null): ResultData<Nothing>()
}