package com.example.androidaiassistant.data.repository

import com.example.androidaiassistant.data.remote.GeminiService
import com.example.androidaiassistant.domain.model.ChatMessage
import com.example.androidaiassistant.domain.repository.ChatRepository

class ChatRepositoryImpl(

    private val geminiService: GeminiService

) : ChatRepository {

    override suspend fun sendMessage(
        message: String
    ): ChatMessage {

        val ai =
            geminiService.askAI(message)

        return ChatMessage(

            id = System.currentTimeMillis(),

            message = ai,

            isUser = false,

            timestamp = System.currentTimeMillis()
        )
    }

}
