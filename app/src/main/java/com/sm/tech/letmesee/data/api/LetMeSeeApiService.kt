package com.sm.tech.letmesee.data.api


import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url


interface LetMeSeeApiService{
    @Headers(
        "Ocp-Apim-Subscription-Key: 3be7b07a-4d08-4328-9426-333d842872f0",
        "Accept:application/json"
    )
    @GET("v7.0/news/search?q=4a9e1e5034494a2e9fa9db5c6916e19b")
      fun getSearch( ): Call<List<LetMeSeeEntity>>
}