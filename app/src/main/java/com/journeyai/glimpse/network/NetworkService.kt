package com.journeyai.glimpse.network

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.util.Log
import com.journeyai.glimpse.models.ImageCategoryRequest
import com.journeyai.glimpse.models.ImageCategoryResponse
import com.journeyai.glimpse.models.JournalEntryRequest
import com.journeyai.glimpse.models.JournalEntryResponse
import com.squareup.moshi.Moshi
import io.grpc.netty.shaded.io.netty.handler.logging.LogLevel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.Duration

/**
 * {
 *   "user_id": "1",
 *   "start_date": "2023-09-15",
 *   "end_date": "2023-09-20"
 * }
 */
interface AIService {
    @Headers("Content-Type: application/json")
    @POST("image_categories")
    suspend fun imageCategories(
        @Body request: ImageCategoryRequest,
    ): ImageCategoryResponse
    @Headers("Content-Type: application/json")
    @POST("journal_entry")
    suspend fun journalEntry(
        @Body request: JournalEntryRequest,
    ): JournalEntryResponse
}

object RetrofitInstance {
    private const val BASE_URL = "https://us-central1-gdg-demos.cloudfunctions.net"

    private fun provideMoshi(): Moshi =
        Moshi
            .Builder()
            .build()

    private fun provideOkHttp(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .callTimeout(Duration.ofSeconds(60))
            .connectTimeout(Duration.ofSeconds(60))
            .readTimeout(Duration.ofSeconds(60))
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttp())
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
            .build()
    }

    private val aiService: AIService by lazy {
        retrofit.create(AIService::class.java)
    }

    suspend fun imageCategories(request: ImageCategoryRequest): ImageCategoryResponse {
        try {
            return aiService.imageCategories(request)
        } catch (e: Exception) {
            Log.e("NetworkService", "Problems calling imageCategories",e)
        }
        return ImageCategoryResponse()
    }
    suspend fun journalEntry(request: JournalEntryRequest): JournalEntryResponse {
        try {
            return aiService.journalEntry(request)
        } catch (e: Exception) {
            Log.e("NetworkService", "Problems calling Journal Entry",e)
        }
        return JournalEntryResponse()
    }
}
