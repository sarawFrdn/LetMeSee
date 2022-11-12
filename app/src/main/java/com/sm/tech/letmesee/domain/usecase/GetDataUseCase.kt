package com.sm.tech.letmesee.domain.usecase

import com.sm.tech.letmesee.data.LetMeSeeNewsRepositoryImpl
import com.sm.tech.letmesee.domain.LetMeSeeRepository
import com.sm.tech.letmesee.domain.model.DataModel

class GetDataUseCaseImpl(var repository: LetMeSeeRepository) : GetDataUseCase {

    override suspend fun getNews(): DataModel? {
        return repository.getListofData()?.toModel()
    }
}

interface GetDataUseCase {
    suspend fun getNews(): DataModel?
}