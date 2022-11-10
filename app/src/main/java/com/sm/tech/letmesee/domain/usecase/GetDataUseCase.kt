package com.sm.tech.letmesee.domain.usecase

import com.sm.tech.letmesee.domain.LetMeSeeRepository
import com.sm.tech.letmesee.domain.model.DataModel

class GetDataUseCase(var repository: LetMeSeeRepository) {

    fun getNews(): List<DataModel> {
        return repository.getListofData()
    }
}