package com.example.androidaiassistant.presentation.chat

import com.example.androidaiassistant.domain.model.ChatMessage

data class ChatUiState(val messages: List<ChatMessage> = emptyList(),
                       val isLoading: Boolean = false,
                       val error: String? = null
)
