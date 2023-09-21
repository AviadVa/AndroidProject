package hackeru.lesson.project.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hackeru.lesson.project.R
import hackeru.lesson.project.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    private var _binding: FragmentGameOverBinding? = null

    //use after init:
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //here we inflate the fragment
        _binding = FragmentGameOverBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // we use arguments to receive the answer we sent and print it on the screen
        val answer  = arguments?.getString("answer") ?: "You didn't chose..."
        binding.failedText.text = "'" + answer + "', \n is not the nicest answer, why not try again?"

        //here we send the user to try again since we don't like his answer
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
        }
    }

    //this is to Destroy the fragment once we move on (no longer in the page)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}