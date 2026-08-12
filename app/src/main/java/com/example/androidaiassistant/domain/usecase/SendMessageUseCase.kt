package com.example.androidaiassistant.domain.usecase

import com.example.androidaiassistant.domain.repository.ChatRepository

class SendMessageUseCase(
    private val repository: ChatRepository
) {
    suspend operator fun invoke(
        message: String
    ) =
        repository.sendMessage(message)

}