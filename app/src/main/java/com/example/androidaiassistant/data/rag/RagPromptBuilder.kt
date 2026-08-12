package com.example.androidaiassistant.data.rag

class RagPromptBuilder {

    fun build(
        question: String,
        chunks: List<DocumentChunk>
    ): String {

        val context = chunks.joinToString(
            separator = "\n\n"
        ) {
            """
            ${it.title}
            
            ${it.content}
            """.trimIndent()
        }

        return """
            You are an Android development assistant.

            Answer the user's question using the
            provided context.

            If the answer cannot be found in the
            context, clearly say that the information
            is not available in the provided knowledge base.

            Context:
            $context

            Question:
            $question
        """.trimIndent()
    }
}