package hackeru.lesson.lec17homework1.repository

import androidx.lifecycle.LiveData
import hackeru.lesson.lec17homework1.data.MovieDao
import hackeru.lesson.lec17homework1.entity.Movie
import hackeru.lesson.lec17homework1.mapper.toMovie
import hackeru.lesson.lec17homework1.service.TMDBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDao: MovieDao) {

    fun getMovies() : LiveData<List<Movie>> {
        return movieDao.getMovies()
    }

    suspend fun refreshMovies(){
        withContext(Dispatchers.IO){
            val movieResponse = TMDBService.create().getMovies()
            movieDao.add(movieResponse.movies.map { dto -> dto.toMovie() })



            //this is the same as this:
            //new empty list<Movie>()
//            val movies = mutableListOf<Movie>()
//
//            //loop through all movieDto's from the response
//            for(dto in movieResponse.movies){
//                movies.add(dto.toMovie())
//            }
        }
    }
}