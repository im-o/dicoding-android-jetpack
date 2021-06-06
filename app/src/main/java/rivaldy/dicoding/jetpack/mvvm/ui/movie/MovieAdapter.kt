package rivaldy.dicoding.jetpack.mvvm.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.ResultMovie
import rivaldy.dicoding.jetpack.mvvm.databinding.RowItemMovieBinding
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.BASE_IMAGE_URL

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

class MovieAdapter(private val listener: (ResultMovie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listCourses = ArrayList<ResultMovie>()

    fun setMovies(movies: MutableList<ResultMovie>?) {
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
        fun bindItem(item: ResultMovie, listener: (ResultMovie) -> Unit) {
            with(binding) {
                val urlImage = BASE_IMAGE_URL+item.backdropPath
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
}