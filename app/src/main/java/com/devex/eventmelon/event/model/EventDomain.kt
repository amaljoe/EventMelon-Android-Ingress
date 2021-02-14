package com.devex.eventmelon.event.model

import com.devex.eventmelon.model.Event

data class EventDomain(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val date: String = "",
    val location: String = "",
    val imageUrl: String = "",
    val maxParticipants: Int = 0,
    val host: String = "",
    val price: String = "Free",
    var favourite: Boolean = false,
)

fun Event.asDomainModel(): EventDomain {
    val priceAsString: String = if (price == 0) {
        "Free"
    } else {
        "₹ $price"
    }
    return EventDomain(
        id = id,
        name = name,
        description = description,
        date = date,
        location = location,
        imageUrl = imageUrl,
        maxParticipants = maxParticipants,
        host = host,
        price = priceAsString
    )
}

fun EventDomain.toggleFavourite(): EventDomain {
    favourite = !favourite
    return this
}
