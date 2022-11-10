package com.sm.tech.letmesee.domain.usecase

import com.sm.tech.letmesee.domain.model.DataModel


interface OnItemClickListener {
    fun onItemClicked(item :DataModel)
}