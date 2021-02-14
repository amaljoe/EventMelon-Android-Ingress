package com.devex.eventmelon.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devex.eventmelon.MainActivity
import com.devex.eventmelon.R
import com.devex.eventmelon.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    var _binding: FragmentLoginBinding? = null
    val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signInButton.setOnClickListener {
            login()
        }
    }


    /**
     * Put token in shared preferences and navigate to main activity
     */
    fun login() {
        // TODO: do login validation with backend
        val sharedPrefs = requireActivity().getSharedPreferences(
            MainActivity.SHARED_PREFS_FILE,
            Context.MODE_PRIVATE
        )
        with(sharedPrefs.edit()) {
            putString(com.devex.eventmelon.MainActivity.TOKEN, "logged in")
            apply()
        }
        Log.d("token", sharedPrefs.contains(MainActivity.TOKEN).toString())
        val mainIntent = Intent(requireActivity(), MainActivity::class.java)
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(mainIntent)
    }
}