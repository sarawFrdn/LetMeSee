package com.sm.tech.letmesee.domain.usecase

import com.sm.tech.letmesee.data.entity.LetMeSeeEntity

interface OnItemClickListener {
    fun onItemClicked(item :LetMeSeeEntity)
}