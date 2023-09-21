package hackeru.lesson.project.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import hackeru.lesson.project.data.AppDatabase
import hackeru.lesson.project.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val context: Application) : AndroidViewModel(context) {

    //init the database:
    private val db = AppDatabase.create(context)

    //init the repo:
    private val repo = MovieRepository(db.movieDao())

    //LiveData from database:
    val movies = repo.getMovies()

    init {
        viewModelScope.launch {
            //refresh from the api:
            repo.refreshMovies()
        }
    }
}