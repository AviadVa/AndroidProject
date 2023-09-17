package hackeru.lesson.lec17homework1.ui.home.details

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import hackeru.lesson.lec17homework1.R
import hackeru.lesson.lec17homework1.databinding.FragmentMovieDetailsBinding
import hackeru.lesson.lec17homework1.entity.Movie


class MovieDetailsFragment : Fragment() {
    private var _binding: FragmentMovieDetailsBinding? = null

    //use after init:
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("Movie", Movie::class.java) ?: return
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelable("Movie") ?: return
        }

        with(binding){
            Picasso.get().load(movie.backdropUrl).into(imageBackdrop)
            Picasso.get().load(movie.posterUrl).into(imagePoster)
            overviewText.text = movie.overview
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}