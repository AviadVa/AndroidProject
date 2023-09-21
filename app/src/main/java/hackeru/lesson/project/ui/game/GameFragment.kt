package hackeru.lesson.project.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hackeru.lesson.project.R
import hackeru.lesson.project.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    //use after init:
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //here we inflate the fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //we use Bundle() to save the answer and move it to the next fragment
        val bundle = Bundle()

        //now we will find put what the user answered and move it to the next fragment when he 'click' / 'answer'
        // we repeats this 4 times since we have 4 answers

        //check if the answer is "Yes, very much" then we will send the user to gameWonFragment
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.yes1) {
                binding.btnSubmit.setOnClickListener {
                    bundle.putString("answer", "Yes, very much")
                    findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment, bundle)
                }
            }
            //check if the answer is "Yes, but i won't be back" then we will send the user to gameOverFragment
            if (checkedId == R.id.yes2) {
                binding.btnSubmit.setOnClickListener {
                    bundle.putString("answer", "Yes, but i won't be back")
                    findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment, bundle)
                }
            }
            //check if the answer is "No. it was bad!" then we will send the user to gameOverFragment
            if (checkedId == R.id.no1) {
                binding.btnSubmit.setOnClickListener {
                    bundle.putString("answer", "No. it was bad!")
                    findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment, bundle)
                }
            }
            //check if the answer is "No, it was only so-so" then we will send the user to gameOverFragment
            if (checkedId == R.id.no2) {
                binding.btnSubmit.setOnClickListener {
                    bundle.putString("answer", "No, it was only so-so")
                    findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment, bundle)
                }
            }
        }
//            }
    }


    //this is to Destroy the fragment once we move on (no longer in the page)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}