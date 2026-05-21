package com.premium.dialer.data

import com.premium.dialer.model.*

object FakeData {
    val contacts = listOf(
        Contact("1","Carl Pei","Nothing Founder","+1 202 555 0131","https://i.pravatar.cc/600?img=12",true),
        Contact("2","Akis Evangelidis","Nothing Co-founder","+1 202 555 0174","https://i.pravatar.cc/600?img=15",true),
        Contact("3","Max","Mobile, Yesterday, 01:00 pm, Jio","+1 202 555 0142","https://i.pravatar.cc/600?img=11",redAccent = true),
        Contact("4","Priyanshu","Focus mode","+1 202 555 0188","https://i.pravatar.cc/600?img=56", true),
        Contact("5","Vivek Bhimani","Nothing Community","+91 98765 43210","https://i.pravatar.cc/600?img=58", true)
    )

    val recents = listOf(
        RecentCall("r1", contacts[0], CallDirection.OUTGOING, "Mobile, 01:10 pm, Jio"),
        RecentCall("r2", contacts[2], CallDirection.MISSED, "Mobile, Yesterday, 01:00 pm, Jio"),
        RecentCall("r3", contacts[1], CallDirection.OUTGOING, "Mobile, Yesterday, 01:10 pm, Airtel"),
        RecentCall("r4", contacts[3], CallDirection.INCOMING, "Mobile, Yesterday, Airtel")
    )

    val history = listOf(
        CallHistoryItem("h1", CallDirection.INCOMING, "Today 01:10 pm", "+91 98765 43210", "30s"),
        CallHistoryItem("h2", CallDirection.MISSED, "Today 01:10 pm", "+91 12345 67890", "--"),
        CallHistoryItem("h3", CallDirection.OUTGOING, "Today 01:10 pm", "+91 98765 43210", "8m 28s")
    )
}
