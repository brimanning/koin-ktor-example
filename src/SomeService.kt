package com.brimanning.koinktorexample

import java.util.*

class SomeService {
    fun helloMessage() = "Hi from Ktor! The current time in millis is: ${Calendar.getInstance().timeInMillis}"
}