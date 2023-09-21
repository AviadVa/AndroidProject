package hackeru.lesson.project.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hackeru.lesson.project.entity.Movie

// this is were we define our Query methods so we interact with the Database
//this is to save new movies for example to the local Database
@Dao
interface MovieDao {

    //@Insert Query methods - to add a new movie to the Database
    //REPLACE = update db from cloud in case it is already in the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(movies: List<Movie>)


    //@Query Query methods - to find the movie in the Database
    @Query("SELECT * FROM Movie")
    fun getMovies(): LiveData<List<Movie>>

}