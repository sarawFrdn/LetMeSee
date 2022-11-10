package com.sm.tech.letmesee.data.network

import com.sm.tech.letmesee.data.entity.LetMeSeeEntity


interface LetMeSeeRemoteDateSource {
     fun getList(): List<LetMeSeeEntity>
}