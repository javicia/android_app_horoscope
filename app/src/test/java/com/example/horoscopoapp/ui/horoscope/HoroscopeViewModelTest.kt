package com.example.horoscopoapp.ui.horoscope

import com.example.horoscopoapp.data.providers.HoroscopeProvider
import com.example.horoscopoapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest{
    private lateinit var viewModel: HoroscopeViewModel

    @MockK
    lateinit var horoscopoProvider: HoroscopeProvider

    @Before
    fun setUp(){
    MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewModel is created then horoscopes are loaded`(){
        every { horoscopoProvider.getHoroscope() } returns horoscopeInfoList
        viewModel= HoroscopeViewModel(horoscopoProvider)

        val horoscopes = viewModel.horoscope.value

        assertTrue(horoscopes.isNotEmpty())
    }
}