package com.sm.tech.letmesee.data.network

import android.util.Log
import com.sm.tech.letmesee.data.api.LetMeSeeApiService
import com.sm.tech.letmesee.data.entity.Articles
import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

class LetMeSeeRemoteDataSourceImpl: LetMeSeeRemoteDateSource {

    private var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(
        30,
        TimeUnit.SECONDS
    ).addInterceptor(interceptor).build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(LetMeSeeApiService::class.java)




    override suspend fun getSearch(): LetMeSeeEntity? = withContext(Dispatchers.IO) {

        try {
            val result = service.getSearch()
            if (result.isSuccessful) result.body() else null
        } catch (ex: Exception) {
            Log.e("retrofit call : ",ex.message.toString())
            null
        }

    }
}