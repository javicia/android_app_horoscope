package com.example.horoscopoapp.data.network.response

import com.example.horoscopoapp.motherobject.HoroscopeMotherObject
import com.example.horoscopoapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test

class PredictionResponseTest {

    @Test
    fun `to Domain should return a correct Prediction`() {
        //Given
        val horoscopeResponse= anyResponse
        //When
        val predictionModel= horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe  horoscopeResponse.horoscope
    }
}