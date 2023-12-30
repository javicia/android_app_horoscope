package com.example.horoscopoapp.motherobject

import com.example.horoscopoapp.data.network.response.PredictionResponse
import com.example.horoscopoapp.domain.model.HoroscopeInfo.*


object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("dates", "prediction", "taurus")

    val horoscopeInfoList = listOf(
        Aries,
        Taurus,
        Gemini,
        Cancer,
        Leo,
        Virgo,
        Libra,
        Scorpio,
        Sagittarius,
        Capricorn,
        Aquarius,
        Pisces
    )
}