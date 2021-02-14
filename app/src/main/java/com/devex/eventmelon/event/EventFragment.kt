package com.devex.eventmelon.event

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.devex.eventmelon.databinding.FragmentEventBinding


class EventFragment : Fragment() {
    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!
    private lateinit var eventId: String
    private val viewModel: EventViewModel by lazy {
        ViewModelProvider(requireActivity()).get(EventViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        eventId = EventFragmentArgs.fromBundle(requireArguments()).id
        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setupWithNavController(view.findNavController())
        viewModel.getEvent(eventId)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        viewModel.event.observe(viewLifecycleOwner) {
            Log.d("eventview", it.description)
        }
    }
}