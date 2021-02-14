package com.devex.eventmelon.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.devex.eventmelon.R
import com.devex.eventmelon.databinding.FragmentEventBinding
import com.devex.eventmelon.home.adapter.EventItemClickListener
import com.devex.eventmelon.home.adapter.ItemAdapter
import com.devex.eventmelon.model.Event


class HomeFragment : Fragment() {
    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myDataset: List<Event> = listOf(Event())



        val recyclerView = view.findViewById<RecyclerView>(R.id.thisweekrecview_home)
        val itemAdapter = ItemAdapter(requireContext(), myDataset, EventItemClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_eventFragment, bundleOf("id" to it))
        })

        recyclerView.adapter = itemAdapter

        viewModel.myEvents.observe(viewLifecycleOwner){
            itemAdapter.dataset = it
            itemAdapter.notifyDataSetChanged()
        }

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recommendedrecview_home)
        recyclerView2.adapter = itemAdapter

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView2.setHasFixedSize(true)

    }

}
