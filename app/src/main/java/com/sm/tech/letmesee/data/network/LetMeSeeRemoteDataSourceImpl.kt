package com.sm.tech.letmesee.data.network

import android.util.Log
import com.sm.tech.letmesee.data.api.LetMeSeeApiService
import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class LetMeSeeRemoteDataSourceImpl(
    ): LetMeSeeRemoteDateSource {

    var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
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


    override  fun getList():List<LetMeSeeEntity> {
        val call = service.getSearch()
         call.enqueue(object : Callback<List<LetMeSeeEntity>> {
            override fun onResponse(
                call: Call<List<LetMeSeeEntity>>, response: Response<List<LetMeSeeEntity>>
            ) {
                if (response.code() == 200) {
                    Log.d("show", "onResponse: " + response.toString())
                } else {
                    Log.d("else", "onResponse: ")
                }
            }

            override fun onFailure(call: Call<List<LetMeSeeEntity>>, t: Throwable) {
                Log.d("fail", t.message.toString())
            }

        })
       return getList()
    }
}