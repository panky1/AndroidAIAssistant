package com.example.androidaiassistant.domain.usecase

import com.example.androidaiassistant.data.rag.RagPromptBuilder
import com.example.androidaiassistant.data.rag.RagRetriever
import com.example.androidaiassistant.domain.model.ChatMessage
import com.example.androidaiassistant.domain.repository.ChatRepository

class AskQuestionUseCase(
    private val ragRetriever: RagRetriever,
    private val promptBuilder: RagPromptBuilder,
    private val repository: ChatRepository
) {

    suspend operator fun invoke(
        question: String
    ): ChatMessage {

        val chunks =
            ragRetriever.retrieve(question)

        val prompt =
            promptBuilder.build(
                question,
                chunks
            )

        return repository.sendMessage(prompt)
    }
}