package com.devex.eventmelon.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.devex.eventmelon.R
import com.devex.eventmelon.databinding.FragmentSignupMainBinding

class SignupMainFragment : Fragment() {

    var _binding: FragmentSignupMainBinding? = null
    val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * Add navigation to login fragment
         */
        binding.signInTextView.setOnClickListener {
            view.findNavController().navigate(R.id.action_signupMainFragment_to_loginFragment)
        }
        /**
         * Add navigation to signup fragment
         */
        binding.signupButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_signupMainFragment_to_signupFragment)
        }
    }
}