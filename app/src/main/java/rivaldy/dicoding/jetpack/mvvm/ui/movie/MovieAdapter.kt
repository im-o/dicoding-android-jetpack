package rivaldy.dicoding.jetpack.mvvm.ui.movie

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.model.offline.MovieData
import rivaldy.dicoding.jetpack.mvvm.databinding.RowItemMovieBinding
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.isVisible

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieAdapter(private val listener: (MovieData) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listCourses = ArrayList<MovieData>()

    fun setMovies(movies: List<MovieData>?) {
        if (movies == null) return
        this.listCourses.clear()
        this.listCourses.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val rowItemMovieBinding = RowItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(rowItemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listCourses[position]
        holder.bindItem(movie, listener)
    }

    override fun getItemCount(): Int = listCourses.size

    class MovieViewHolder(private val binding: RowItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: MovieData, listener: (MovieData) -> Unit) {
            with(binding) {
                movieTitleTV.text = item.title
                movieDateTV.text = item.date
                movieRateTV.text = item.rate

                Glide.with(itemView.context)
                    .load(ContextCompat.getDrawable(itemView.context, item.imgPath))
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            loadingPB.isVisible(true)
                            return true
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            loadingPB.isVisible(false)
                            return false
                        }
                    })
                    .into(movieImageIV)
                root.setOnClickListener { listener(item) }
            }
        }
    }
}