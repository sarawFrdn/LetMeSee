package com.sm.tech.letmesee.domain

import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import com.sm.tech.letmesee.domain.model.DataModel

interface LetMeSeeRepository {
   suspend fun getListofData(): List<DataModel>
}