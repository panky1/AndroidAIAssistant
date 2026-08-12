package com.example.androidaiassistant.data.remote

import com.example.androidaiassistant.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel

class GeminiService {

    private val model = GenerativeModel(
        modelName = "gemini-2.5-flash",
        apiKey = BuildConfig.GEMINI_API_KEY
    )

    suspend fun askAI(
        prompt: String
    ): String {

        val response =
            model.generateContent(prompt)

        return response.text ?: "No response"
    }
}