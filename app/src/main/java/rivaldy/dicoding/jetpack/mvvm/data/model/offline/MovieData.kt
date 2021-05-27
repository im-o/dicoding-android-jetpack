package rivaldy.dicoding.jetpack.mvvm.data.model.offline

/**
 * Created by rivaldy on 28/05/21
 * Find me on my Github -> https://github.com/im-o
 **/

data class MovieData(
    var moviesId: String,
    var title: String,
    var imgPath: Int,
    var rate: String,
    var date: String,
    var genre: String,
    var desc: String,
    var duration: String,
    var country: String
)