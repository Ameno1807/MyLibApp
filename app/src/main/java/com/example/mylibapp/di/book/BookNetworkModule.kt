package com.example.mylibapp.di.book

import com.example.mylibapp.data.anime.remote.retrofit.AnimeApiService
import com.example.mylibapp.data.book.remote.retrofit.BookApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class BookNetworkModule {

    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    private val contentType = "application/json".toMediaType()

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addNetworkInterceptor(loggingInterceptor)
        .build()

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://mylibapp.getsandbox.com")
        .addConverterFactory(json.asConverterFactory(contentType))
        .client(httpClient)

    private val retrofit = retrofitBuilder.build()

    val api: BookApiService by lazy { retrofit.create(BookApiService::class.java) }
}