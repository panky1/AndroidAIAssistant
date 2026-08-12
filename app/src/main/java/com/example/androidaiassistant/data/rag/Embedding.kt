package com.example.androidaiassistant.data.rag

data class Embedding(
    val chunkId: String,
    val vector: List<Float>
)