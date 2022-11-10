package com.sm.tech.letmesee.domain.usecase

import com.sm.tech.letmesee.domain.LetMeSeeRepository
import com.sm.tech.letmesee.domain.model.DataModel

class GetDataUseCase(var repository: LetMeSeeRepository) {

    suspend fun getNews(): List<DataModel> {
        return repository.getListofData()
    }
}