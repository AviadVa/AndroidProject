package hackeru.lesson.project.mapper

import hackeru.lesson.project.entity.Movie
import hackeru.lesson.project.service.dto.MovieDTO


const val TMDB_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

//here I add the function toMovie to the class MovieDTO
//dto mapping
//this fun is so we can read the data from the table of class Movie and MovieDTO correctly
fun MovieDTO.toMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    posterUrl = "$TMDB_IMAGE_URL$posterPath",
    backdropUrl = "$TMDB_IMAGE_URL$backdropPath",
    adult = adult,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    popularity = popularity,
    releaseDate = releaseDate,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)