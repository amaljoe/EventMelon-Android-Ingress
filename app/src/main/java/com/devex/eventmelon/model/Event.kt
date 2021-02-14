package com.devex.eventmelon.model

data class Event(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val date: String = "",
    val location: String = "",
    val imageUrl: String = "",
    val maxParticipants: Int = 0,
    val host: String = "",
    val price: Int = 0
)

