package com.example.androidaiassistant.domain.repository

import com.example.androidaiassistant.domain.model.ChatMessage

interface  ChatRepository {
    suspend fun sendMessage(
        message: String
    ): ChatMessage
}