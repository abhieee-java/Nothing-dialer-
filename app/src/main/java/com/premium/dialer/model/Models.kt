package com.premium.dialer.model

enum class CallDirection { INCOMING, OUTGOING, MISSED }

data class Contact(
    val id: String,
    val name: String,
    val subtitle: String,
    val phone: String,
    val image: String,
    val favorite: Boolean = false,
    val redAccent: Boolean = false
)

data class RecentCall(
    val id: String,
    val contact: Contact,
    val direction: CallDirection,
    val carrierTime: String
)

data class CallHistoryItem(
    val id: String,
    val direction: CallDirection,
    val time: String,
    val number: String,
    val duration: String
)
