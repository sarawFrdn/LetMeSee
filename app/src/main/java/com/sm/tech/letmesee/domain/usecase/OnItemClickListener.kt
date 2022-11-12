package com.sm.tech.letmesee.domain.usecase

import com.sm.tech.letmesee.data.entity.Articles


interface OnItemClickListener {
    fun onItemClicked(item: Articles)
}