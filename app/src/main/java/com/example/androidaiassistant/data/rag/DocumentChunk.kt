package com.example.androidaiassistant.data.rag

data class DocumentChunk(
    val id: String,
    val documentId: String,
    val title: String,
    val content: String
)
