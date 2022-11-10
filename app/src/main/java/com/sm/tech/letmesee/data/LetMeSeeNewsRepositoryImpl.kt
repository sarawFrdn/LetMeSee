package com.sm.tech.letmesee.data

import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDateSource
import com.sm.tech.letmesee.domain.LetMeSeeRepository
import com.sm.tech.letmesee.domain.model.DataModel


class LetMeSeeNewsRepositoryImpl(): LetMeSeeRepository {
    override fun getListofData(): List<DataModel> {

        var items: List<LetMeSeeEntity> = ArrayList<LetMeSeeEntity>()
        return items.map{
            it.toModel()
        }
    }
}