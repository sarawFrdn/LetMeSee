package com.sm.tech.letmesee.domain

import com.sm.tech.letmesee.data.entity.LetMeSeeEntity

interface LetMeSeeRepository {
   suspend fun getListofData(): LetMeSeeEntity?
}