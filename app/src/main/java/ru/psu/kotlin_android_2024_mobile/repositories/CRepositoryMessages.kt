package ru.psu.kotlin_android_2024_mobile.repositories

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory



class CRepositoryMessages {
    companion object {
        private const val BASE_URL =
            "http://192.168.1.4:8080/"

        private val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
         }

        private val retrofit: Retrofit = Retrofit.Builder()
            //.addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()

        val service : IServiceMessages by lazy {
            retrofit.create(IServiceMessages::class.java)
        }
    }



}