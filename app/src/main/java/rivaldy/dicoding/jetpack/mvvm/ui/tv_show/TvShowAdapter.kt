package rivaldy.dicoding.jetpack.mvvm.ui.tv_show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.databinding.RowItemMovieBinding
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.isVisible

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class TvShowAdapter(private val listener: (MovieData) -> Unit) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listCourses = ArrayList<MovieData>()

    fun setTvShows(tvShows: List<MovieData>?) {
        if (tvShows == null) return
        this.listCourses.clear()
        this.listCourses.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val rowItemMovieBinding = RowItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(rowItemMovieBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val movie = listCourses[position]
        holder.bindItem(movie, listener)
    }

    override fun getItemCount(): Int = listCourses.size

    class TvShowViewHolder(private val binding: RowItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: MovieData, listener: (MovieData) -> Unit) {
            with(binding) {
                movieTitleTV.text = item.title
                movieDateTV.text = item.date
                movieRateTV.text = item.rate

                val picasso = Picasso.get()
                picasso.setIndicatorsEnabled(true)
                picasso.load(item.imgPath)
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .into(movieImageIV)
                root.setOnClickListener { listener(item) }
            }
        }
    }
}