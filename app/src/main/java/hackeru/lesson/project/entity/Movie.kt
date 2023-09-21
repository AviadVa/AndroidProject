package hackeru.lesson.project.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize



//this is our table in the SQL database, so we need the Annotation of @Entity
@Entity
@Parcelize
data class Movie(

    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val backdropUrl: String,
    val adult: Boolean,
    val originalLanguage: String,
    val originalTitle: String,
    val popularity: Double,
    val releaseDate: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) : Parcelable