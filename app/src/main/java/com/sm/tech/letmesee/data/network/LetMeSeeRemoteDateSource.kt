package com.sm.tech.letmesee.data.network


import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import retrofit2.Response


interface LetMeSeeRemoteDateSource {
    suspend fun getSearch(): LetMeSeeEntity?
}