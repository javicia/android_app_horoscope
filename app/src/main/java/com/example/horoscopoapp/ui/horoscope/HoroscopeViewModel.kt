package com.example.horoscopoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscopoapp.data.providers.HoroscopeProvider
import com.example.horoscopoapp.domain.model.HoroscopeInfo
import com.example.horoscopoapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider): ViewModel(){

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value =  horoscopeProvider.getHoroscope()
    }

    fun example(){

    }
}