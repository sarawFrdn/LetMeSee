package com.sm.tech.letmesee.di

import com.sm.tech.letmesee.di.modules.LetMeSeeModule

object LetMeSeeInject {
    fun provideDependency()= listOf(LetMeSeeModule)
}