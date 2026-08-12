package com.example.androidaiassistant.data.datasource

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class FakeChatDataSource {
    suspend fun getResponse(
        message: String
    ): String {

        delay(1500.milliseconds)

        return "AI Response for: $message"
    }
}