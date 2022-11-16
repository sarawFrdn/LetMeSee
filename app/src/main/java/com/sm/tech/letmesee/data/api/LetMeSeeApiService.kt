package com.sm.tech.letmesee.data.api


import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url


interface LetMeSeeApiService{
    @GET("/v2/everything")

    suspend fun getSearch(@Query("q") search: String
                        ,@Query("from") from: String
                        ,@Query("to") to: String,
                        @Query("sortBy") sortBy: String
                        ,@Query("apiKey") apiKey:String): Response<LetMeSeeEntity>
}