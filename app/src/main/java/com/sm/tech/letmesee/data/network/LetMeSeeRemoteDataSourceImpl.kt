package com.sm.tech.letmesee.data.network

import android.util.Log
import com.sm.tech.letmesee.data.api.LetMeSeeApiService
import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LetMeSeeRemoteDataSourceImpl(
    ): LetMeSeeRemoteDateSource {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.bing.microsoft.com")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: LetMeSeeApiService = retrofit.create(LetMeSeeApiService::class.java)


    override  fun getList() {

        val call = service.getSearch()
        call.enqueue(object : Callback<List<LetMeSeeEntity>>{
            override fun onResponse(call: Call<List<LetMeSeeEntity>>, response: Response<List<LetMeSeeEntity>>
            ) {
                if (response.code() == 200) {

                    Log.d("movies", "onResponse: " + response.toString())
                } else {
                    Log.d("else", "onResponse: ")
                }
            }

            override fun onFailure(call: Call<List<LetMeSeeEntity>>, t: Throwable) {
                Log.d("fail", "onFailure: ")
            }

        })
    }
}