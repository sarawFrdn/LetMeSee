package com.sm.tech.letmesee.data

import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSourceImpl
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDateSource
import com.sm.tech.letmesee.domain.LetMeSeeRepository
import retrofit2.Response


class LetMeSeeNewsRepositoryImpl(private var items: LetMeSeeRemoteDateSource): LetMeSeeRepository {

    override suspend fun getListofData(): LetMeSeeEntity? {
        return items.getSearch()
    }
}