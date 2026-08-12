package com.example.androidaiassistant.data.datasource

import com.example.androidaiassistant.data.rag.DocumentChunk


class KnowledgeDataSource {

    fun getChunks(): List<DocumentChunk> {

        return listOf(

            DocumentChunk(
                id = "1",
                documentId = "android_architecture",
                title = "MVVM",
                content = """
                    MVVM stands for Model View ViewModel.
                    ViewModel manages UI-related state and
                    separates UI logic from business logic.
                """.trimIndent()
            ),

            DocumentChunk(
                id = "2",
                documentId = "android_architecture",
                title = "StateFlow",
                content = """
                    StateFlow is a state-holder observable flow.
                    It represents a read-only observable state
                    that emits the current and updated values.
                """.trimIndent()
            ),

            DocumentChunk(
                id = "3",
                documentId = "android_architecture",
                title = "Repository",
                content = """
                    Repository abstracts the data sources
                    from the rest of the application.
                    It can provide data from remote APIs,
                    databases, or other sources.
                """.trimIndent()
            ),

            DocumentChunk(
                id = "4",
                documentId = "android_architecture",
                title = "Clean Architecture",
                content = """
                    Clean Architecture separates an application
                    into layers such as presentation, domain,
                    and data.
                """.trimIndent()
            )
        )
    }
}