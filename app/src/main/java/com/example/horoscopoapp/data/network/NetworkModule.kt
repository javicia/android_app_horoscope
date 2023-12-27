package com.example.horoscopoapp.data.network

import com.example.horoscopoapp.BuildConfig.BASE_URL
import com.example.horoscopoapp.data.RepositoryImpl
import com.example.horoscopoapp.data.core.interceptors.AuthInterceptor
import com.example.horoscopoapp.domain.repositary.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providerRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient{

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .addInterceptor(authInterceptor)
        .build()
    }

    @Provides
    fun providerHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun providerRepository(apiService: HoroscopeApiService):Repository{
        return RepositoryImpl(apiService)
    }
}