package rivaldy.dicoding.jetpack.mvvm.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.Toast

/**
 * Created by rivaldy on 28/05/21
 * Find me on my lol Github :D -> https://github.com/im-o
 **/

object UtilExtensions {
    fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
        val intent = Intent(this, it)
        intent.putExtras(Bundle().apply(extras))
        startActivity(intent)
    }

    fun View.isVisible(isVisible: Boolean) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    fun Context.myToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun EditText.setTextEditable(text: String) {
        this.text = Editable.Factory.getInstance().newEditable(text)
    }
}
