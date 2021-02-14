package com.devex.eventmelon.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.devex.eventmelon.LoginActivity
import com.devex.eventmelon.MainActivity
import com.devex.eventmelon.R


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val logoutButton = view.findViewById<Button>(R.id.logout_button)
        logoutButton.setOnClickListener {
            logout()
        }
    }

    fun logout() {
        val sharedPrefs = requireActivity().getSharedPreferences(MainActivity.SHARED_PREFS_FILE, Context.MODE_PRIVATE)
        with(sharedPrefs.edit()) {
            remove(MainActivity.TOKEN)
            apply()
        }
        val loginIntent = Intent(requireActivity(), LoginActivity::class.java)
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(loginIntent)
    }
}