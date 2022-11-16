package com.sm.tech.letmesee.data.network


import com.sm.tech.letmesee.data.api.LetMeSeeApiService
import com.sm.tech.letmesee.data.entity.LetMeSeeEntity


interface LetMeSeeRemoteDataSource {
    suspend fun getSearch(queryParams : String): LetMeSeeEntity?
}