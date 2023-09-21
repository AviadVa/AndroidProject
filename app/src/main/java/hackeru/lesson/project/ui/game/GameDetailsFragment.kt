package hackeru.lesson.project.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hackeru.lesson.project.R
import hackeru.lesson.project.databinding.FragmentGameDetailsBinding

class GameDetailsFragment : Fragment() {

    private var _binding: FragmentGameDetailsBinding? = null

    //use after init:
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //here we inflate the fragment
        _binding = FragmentGameDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //here we want to open our GameFragment once the user click on the begin button
        binding.btnPlay.setOnClickListener {
            findNavController().navigate(R.id.gameFragment)
        }


    }

    //this is to Destroy the fragment once we move on (no longer in the page)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}