package hackeru.lesson.project.repository

import androidx.lifecycle.LiveData
import hackeru.lesson.project.data.MovieDao
import hackeru.lesson.project.entity.Movie
import hackeru.lesson.project.mapper.toMovie
import hackeru.lesson.project.service.TMDBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//here we combine the Database and the Service and use them
class MovieRepository(private val movieDao: MovieDao) {


    //here we receive the movie using LiveData
    fun getMovies() : LiveData<List<Movie>> {
        return movieDao.getMovies()
    }


    //in case we want to add a movie, we need to do it correctly -
    suspend fun refreshMovies(){
        withContext(Dispatchers.IO){
            val movieResponse = TMDBService.create().getMovies()
            movieDao.add(movieResponse.movies.map { dto -> dto.toMovie() })



            //this is the same as this but longer:
            //new empty list<Movie>()

//            val movies = mutableListOf<Movie>()
//            //loop through all movieDto's from the response
//            for(dto in movieResponse.movies){
//                movies.add(dto.toMovie())
//            }
        }
    }
}