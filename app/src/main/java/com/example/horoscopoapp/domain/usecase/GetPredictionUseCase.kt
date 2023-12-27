package com.example.horoscopoapp.domain.usecase

import com.example.horoscopoapp.domain.repositary.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}
