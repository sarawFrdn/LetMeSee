package com.sm.tech.letmesee.domain.usecase

import androidx.lifecycle.ViewModel
import com.sm.tech.letmesee.data.LetMeSeeNewsRepositoryImpl
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSourceImpl
import com.sm.tech.letmesee.domain.LetMeSeeRepository
import com.sm.tech.letmesee.domain.model.DataModel
import com.sm.tech.letmesee.presenter.NewsViewModel

class GetDataUseCaseImpl(var repository: LetMeSeeRepository ) : GetDataUseCase {

    override suspend fun getNews(queryParams: String): DataModel? {
        return repository.getListofData(query = queryParams)?.toModel()
    }

}

interface GetDataUseCase {
    suspend fun getNews(queryParams : String): DataModel?
}