package com.example.horoscopoapp.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign:String)
}