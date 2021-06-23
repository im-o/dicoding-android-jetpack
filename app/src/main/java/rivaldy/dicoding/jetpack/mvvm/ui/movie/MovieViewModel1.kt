package rivaldy.dicoding.jetpack.mvvm.ui.movie

/**
 * Created by rivaldy on 13/06/21
 * Find me on my Github -> https://github.com/im-o
 **/

//class MovieViewModel1 @ViewModelInject constructor(
//    private val movieRepository: MovieRepository
//) : ViewModel() {
//
//    private var _movieResponse = MutableLiveData<Resource<MovieResponse>>()
//    val movieResponse: LiveData<Resource<MovieResponse>> = _movieResponse
//
//    fun getMovies() {
//        viewModelScope.launch {
//            _movieResponse.postValue(Resource.loading(null))
//            try {
//                val response = movieRepository.getMovieAsync().await()
//                if (response.results?.size ?: 0 > 0) {
//                    _movieResponse.postValue(Resource.success(response))
//                } else {
//                    _movieResponse.postValue(Resource.error(null, response.results.toString()))
//                }
//            } catch (ex: Exception) {
//                _movieResponse.postValue(Resource.error(null, ex.message.toString()))
//            }
//        }
//    }
//}