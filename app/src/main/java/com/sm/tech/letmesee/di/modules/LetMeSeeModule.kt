package com.sm.tech.letmesee.di.modules

import com.sm.tech.letmesee.data.LetMeSeeNewsRepositoryImpl
import com.sm.tech.letmesee.domain.usecase.GetDataUseCase
import com.sm.tech.letmesee.presenter.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val LetMeSeeModule = module{
    factory {
        GetDataUseCase(get())
    }

    factory {
        LetMeSeeNewsRepositoryImpl()
    }

    viewModel {
        NewsViewModel(get())
    }
}