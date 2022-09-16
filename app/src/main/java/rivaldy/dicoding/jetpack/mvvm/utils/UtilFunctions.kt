package rivaldy.dicoding.jetpack.mvvm.utils

import android.util.Log
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.ERROR_MESSAGE

/**
 * Created by rivaldy on 05/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

object UtilFunctions {
    fun ArrayList<String>.subStringComma(): String {
        val strData = this.toString()
        return strData.substring(1, strData.length - 1)
    }

    fun loge(message: String) {
        Log.e(ERROR_MESSAGE, message)
    }
}