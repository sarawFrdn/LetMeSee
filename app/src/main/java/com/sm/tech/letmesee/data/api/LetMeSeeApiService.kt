package com.sm.tech.letmesee.data.api


import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url


interface LetMeSeeApiService{

    @GET("/v2/everything?q=apple&from=2022-11-08&to=2022-11-08&sortBy=popularity&apiKey=34534b86d45c4ddc8672670d4f7f7590")
      suspend fun getSearch( ): Response<LetMeSeeEntity>
}