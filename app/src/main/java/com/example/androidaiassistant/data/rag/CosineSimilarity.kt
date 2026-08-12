package com.example.androidaiassistant.data.rag

import kotlin.math.sqrt

object CosineSimilarity {

    fun calculate(
        vectorA: List<Float>,
        vectorB: List<Float>
    ): Float {

        require(vectorA.size == vectorB.size) {
            "Vectors must have the same dimensions"
        }

        var dotProduct = 0f
        var magnitudeA = 0f
        var magnitudeB = 0f

        for (i in vectorA.indices) {

            dotProduct +=
                vectorA[i] * vectorB[i]

            magnitudeA +=
                vectorA[i] * vectorA[i]

            magnitudeB +=
                vectorB[i] * vectorB[i]
        }

        val denominator =
            sqrt(magnitudeA) * sqrt(magnitudeB)

        if (denominator == 0f) {
            return 0f
        }

        return dotProduct / denominator
    }
}