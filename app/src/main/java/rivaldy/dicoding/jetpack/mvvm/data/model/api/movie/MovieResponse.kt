package rivaldy.dicoding.jetpack.mvvm.data.model.api.movie

import com.google.gson.annotations.SerializedName

/**
 * Created by rivaldy on 03/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

data class MovieResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: MutableList<ResultMovie>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)