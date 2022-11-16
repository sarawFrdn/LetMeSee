package com.sm.tech.letmesee.data

import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSource
import com.sm.tech.letmesee.domain.LetMeSeeRepository
import com.sm.tech.letmesee.domain.usecase.GetDataUseCase


class LetMeSeeNewsRepositoryImpl(private var items: LetMeSeeRemoteDataSource): LetMeSeeRepository {

    override suspend fun getListofData(query: String): LetMeSeeEntity? {
        return items.getSearch(queryParams = query)
    }
}