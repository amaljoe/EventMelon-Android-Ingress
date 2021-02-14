package com.devex.eventmelon.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devex.eventmelon.event.EventViewModel
import com.devex.eventmelon.model.Event
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeViewModel : ViewModel() {
    companion object {
        /**
         * tag is used for identify debug messages
         */
        val TAG = "HomeViewModel"
    }


    val db = FirebaseFirestore.getInstance()

    /**
     * myEvents hold the events registered by user for that week
     */
    private val _myEvents = MutableLiveData<List<Event>>()
    val myEvents: LiveData<List<Event>>
        get() = _myEvents

    /**
     * recommendedEvents hold the events recommended for the user
     */
    private val _recommededEvents = MutableLiveData<List<Event>>()
    val recommendedEvents: LiveData<List<Event>>
        get() = _myEvents

    init {
        getMyEvents()
    }

    /**
     * getMyEvents will fetch the users' events from the backend
     * TEMPORARY: myEvents and recommendedEvents will be all events in the collection
     */
    fun getMyEvents() {
        //TODO: get only my events in this week
        Log.d(EventViewModel.TAG, "getting my events")
        db.collection("events").get().addOnCompleteListener { it ->
            if (it.isSuccessful) {
                it.result?.let { doc ->
                    _myEvents.value = doc.toObjects(Event::class.java)
                    _recommededEvents.value = _myEvents.value
                }
                Log.d(TAG, "event got ${_myEvents.value}")
            } else {
                throw Exception(it.exception)
            }
        }
    }
}