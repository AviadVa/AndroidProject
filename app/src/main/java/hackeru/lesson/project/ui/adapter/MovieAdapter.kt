package hackeru.lesson.project.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hackeru.lesson.project.entity.Movie
import hackeru.lesson.project.databinding.MovieItemBinding


class MovieAdapter(private val movies: List<Movie>, val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MovieItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItem {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return MovieItem(binding)

        //or this is the same but shorter
        //return  MovieItem(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    //here we get the number of movies in the api we received
    override fun getItemCount():Int {
        return movies.size
    }

    //here we define what will happen once the ViewHolder will show-up
    override fun onBindViewHolder(holder: MovieItem, position: Int) {

        val movie = movies[position]
        with(holder.binding) {
            if (movie.title.length>10){
                textTitle.text = "${movie.title.subSequence(0,10)}..."
            }

            else{
                textTitle.text = movie.title
            }


            //here we add the posterUrl and imagePoster (front and back pics)
            Picasso.get().load(movie.posterUrl).into(imagePoster)
            root.setOnClickListener {
                onClick(movie)
            }
        }
    }


    class MovieItem(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

}