package com.sm.tech.letmesee.di

import com.sm.tech.letmesee.di.modules.letMeSeeModule

object LetMeSeeInject {
    fun provideDependency()= listOf(letMeSeeModule)
}