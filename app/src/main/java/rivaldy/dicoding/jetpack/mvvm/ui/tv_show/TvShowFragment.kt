package rivaldy.dicoding.jetpack.mvvm.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import rivaldy.dicoding.jetpack.mvvm.R

class TvShowFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }
}