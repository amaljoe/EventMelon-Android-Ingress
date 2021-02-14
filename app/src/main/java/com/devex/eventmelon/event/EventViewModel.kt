package com.devex.eventmelon.event

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.devex.eventmelon.event.datasource.Datasource
import com.devex.eventmelon.event.model.EventDomain
import com.devex.eventmelon.event.model.asDomainModel
import com.devex.eventmelon.model.Event
import com.google.firebase.firestore.FirebaseFirestore


class EventViewModel : ViewModel() {
    companion object {
        /**
         * tag is used for identify debug messages
         */
        val TAG = "EventViewModel"
    }

    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    /**
     * event will contain all informations about the event displayed
     * in the screen
     */
    private val _event = MutableLiveData(Event())
    private val _favourite = MutableLiveData(false)

    val favourite: LiveData<Boolean>
        get() = _favourite

    val event: LiveData<EventDomain>
        get() = Transformations.map(_event) {
            it.asDomainModel()
        }


    init {
        //postMockEvent()
    }


    /**
     * getEvent will fetch the event details from the backend
     */
    fun getEvent(id: String) {
        Log.d(TAG, "event getting")
        db.collection("events").document(id).get().addOnCompleteListener { it ->
            if (it.isSuccessful) {
                it.result?.let { doc ->
                    _event.value = doc.toObject(Event::class.java)
                }
                //Log.d(TAG, "event got ${_event.value}")
            } else {
                throw Exception(it.exception)
            }
        }
    }

    /**
     * Favourite the event when the favourite button is clicked
     */
    fun onClickFavourite() {
        //TODO: make a call to backend to favourite the event with event id
        _favourite.value = _favourite.value?.not()
    }

    /**
     * postMockEvent will post a mock event to the backend [Not used in production]
     */
    private fun postMockEvent() {
        Log.d(TAG, "posting event")
        val events = Datasource().loadEvents()
        for(event in events) {
            db.collection("events").document(event.id).set(event)
        }
    }
}