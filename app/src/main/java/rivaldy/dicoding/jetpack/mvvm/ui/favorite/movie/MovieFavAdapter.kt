package rivaldy.dicoding.jetpack.mvvm.ui.favorite.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import rivaldy.dicoding.jetpack.mvvm.BuildConfig
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.model.db.MovieEntity
import rivaldy.dicoding.jetpack.mvvm.databinding.RowItemMovieBinding
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.BASE_IMAGE_URL

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieFavAdapter(private val listener: (MovieEntity) -> Unit) : PagedListAdapter<MovieEntity, MovieFavAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val rowItemMovieBinding = RowItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(rowItemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bindItem(movie ?: return, listener)
    }

    class MovieViewHolder(private val binding: RowItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: MovieEntity, listener: (MovieEntity) -> Unit) {
            with(binding) {
                val urlImage = BuildConfig.BASE_IMAGE_URL + item.backdropPath
                movieTitleTV.text = item.title
                movieDateTV.text = item.releaseDate
                movieRateTV.text = item.voteAverage.toString()

                val picasso = Picasso.get()
                picasso.setIndicatorsEnabled(true)
                picasso.load(urlImage)
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .into(movieImageIV)
                root.setOnClickListener { listener(item) }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}