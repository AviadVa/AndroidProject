package hackeru.lesson.project.service.dto

import com.google.gson.annotations.SerializedName


//we don't want to return everything in the table in the SQL(class Movie) so we made this class MovieResponse
//to decide what to return and what not
data class MovieResponse(
    val page: Int,
    @SerializedName("results")
    val movies: List<MovieDTO>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)