package com.sm.tech.letmesee.domain

import com.sm.tech.letmesee.data.LetMeSeeNewsRepositoryImpl
import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSourceImpl
import com.sm.tech.letmesee.domain.usecase.GetDataUseCase

interface LetMeSeeRepository {
   suspend fun getListofData(query : String): LetMeSeeEntity?
}