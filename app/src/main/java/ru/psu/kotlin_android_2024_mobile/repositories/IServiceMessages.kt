package ru.psu.kotlin_android_2024_mobile.repositories

import retrofit2.http.GET
import retrofit2.http.Query
import ru.psu.kotlin_android_2024_mobile.model.CMessage

interface IServiceMessages {
    @GET("messages")
    suspend fun getLastMessages(@Query("subject") subject : String): List<CMessage>
}