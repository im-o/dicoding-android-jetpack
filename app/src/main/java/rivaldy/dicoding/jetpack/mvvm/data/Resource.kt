package rivaldy.dicoding.jetpack.mvvm.data

/**
 * Created by rivaldy on 13/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

data class Resource<out T>(var status: EnumStatus, val data: T?, val message:String?) {
    companion object{
        fun<T> success(data:T?, msg: String = ""): Resource<T>{
            return Resource(EnumStatus.SUCCESS, data, msg)
        }
        fun<T> error(data:T?, msg: String = ""): Resource<T>{
            return Resource(EnumStatus.ERROR, data, msg)
        }
        fun<T> loading(data:T?): Resource<T>{
            return Resource(EnumStatus.LOADING, data, null)
        }
    }
}

enum class EnumStatus {
    SUCCESS,
    ERROR,
    LOADING
}