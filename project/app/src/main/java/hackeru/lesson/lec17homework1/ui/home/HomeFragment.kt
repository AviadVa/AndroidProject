package hackeru.lesson.lec17homework1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import hackeru.lesson.lec17homework1.R
import hackeru.lesson.lec17homework1.databinding.FragmentHomeBinding
import hackeru.lesson.lec17homework1.databinding.MovieItemBinding
import hackeru.lesson.lec17homework1.ui.adapter.MovieAdapter

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

                    //we can do this:
//                    val args = Bundle()
//                    args.putParcelable("Movie",it)
//                    findNavController().navigate(R.id.action_navigation_home_to_movieDetailsFragment, args)

                    //or we can do this:
                    Bundle().apply {
                        putParcelable("Movie",it)
                        findNavController().navigate(R.id.action_navigation_home_to_movieDetailsFragment, this)
                    }
                }
                layoutManager = GridLayoutManager(context, 3)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}