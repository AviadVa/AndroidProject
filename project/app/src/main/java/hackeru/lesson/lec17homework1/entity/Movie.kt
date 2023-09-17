package hackeru.lesson.lec17homework1.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

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
//    TODO: change to list of Strings:
//    @Ignore
//    val genreIds: List<Int>,
    val originalLanguage: String,
    val originalTitle: String,
    val popularity: Double,
    val releaseDate: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) : Parcelable