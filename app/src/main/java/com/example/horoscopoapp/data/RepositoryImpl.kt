package com.example.horoscopoapp.data

import android.util.Log
import com.example.horoscopoapp.data.network.HoroscopoApiService
import com.example.horoscopoapp.data.network.response.PredictionResponse
import com.example.horoscopoapp.domain.model.PredictionModel
import com.example.horoscopoapp.domain.repositary.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopoApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
       runCatching {apiService.getHoroscope(sign) }
           .onSuccess { return it.toDomain() }
           .onFailure { Log.i("JAVICIA", "Ha ocurrido un error ${it.message}") }
        return null
    }
}