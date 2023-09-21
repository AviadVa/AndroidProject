package hackeru.lesson.project.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hackeru.lesson.project.entity.Movie


const val DB_VERSION = 1
const val DB_NAME = "appdb"

//this is our Database, which is why we need the Annotation of @Database
@Database(entities = [Movie::class], version = DB_VERSION)
abstract class AppDatabase: RoomDatabase() {

    //here we define a function to receive MovieDao
    abstract fun movieDao(): MovieDao

    companion object {
        fun create (context: Context) =
            Room.
            databaseBuilder(context, AppDatabase::class.java, DB_NAME).
            build()
    }
}