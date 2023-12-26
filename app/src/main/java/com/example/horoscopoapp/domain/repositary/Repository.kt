package com.example.horoscopoapp.domain.repositary

import com.example.horoscopoapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}