package rivaldy.dicoding.jetpack.mvvm.data.model.api.movie.detail


import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
    @SerializedName("english_name")
    var englishName: String? = null,
    @SerializedName("iso_639_1")
    var iso6391: String? = null,
    @SerializedName("name")
    var name: String? = null
)