package hackeru.lesson.project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import hackeru.lesson.project.R
import hackeru.lesson.project.databinding.FragmentHomeBinding
import hackeru.lesson.project.ui.adapter.MovieAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
             homeViewModel.movies.observe(viewLifecycleOwner) {
            with(binding.recyclerView) {
                adapter = MovieAdapter(it) {

                    //we can do this to sent the movie the user clicked to the next fragment:
                    Bundle().apply {
                        putParcelable("Movie",it)
                        findNavController().navigate(R.id.action_navigation_home_to_movieDetailsFragment, this)

                        //we can also do this:
//                    val args = Bundle()
//                    args.putParcelable("Movie",it)
//                    findNavController().navigate(R.id.action_navigation_home_to_movieDetailsFragment, args)
                    }
                }

                //here we define we only want 3 in every row on the page
                layoutManager = GridLayoutManager(context, 3)
            }

        }
    }

    //this is to Destroy the fragment once we move on (no longer in the page)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}