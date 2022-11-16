package com.sm.tech.letmesee.di.modules

import com.sm.tech.letmesee.data.LetMeSeeNewsRepositoryImpl
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSourceImpl
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSource
import com.sm.tech.letmesee.domain.LetMeSeeRepository
import com.sm.tech.letmesee.domain.usecase.GetDataUseCase
import com.sm.tech.letmesee.domain.usecase.GetDataUseCaseImpl
import com.sm.tech.letmesee.presenter.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val letMeSeeModule = module {

    factory<LetMeSeeRemoteDataSource> { LetMeSeeRemoteDataSourceImpl() }
    factory<LetMeSeeRepository> { LetMeSeeNewsRepositoryImpl(get()) }

    factory<GetDataUseCase> { GetDataUseCaseImpl(get()) }

//    viewModel {
//        NewsViewModel(get())
//    }

    viewModelOf(::NewsViewModel)
}

