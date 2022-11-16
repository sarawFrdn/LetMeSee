package com.sm.tech.letmesee.data

import com.sm.tech.letmesee.data.entity.Articles
import com.sm.tech.letmesee.data.entity.LetMeSeeEntity
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSource
import com.sm.tech.letmesee.domain.LetMeSeeRepository
import com.sm.tech.letmesee.domain.usecase.GetDataUseCase


class LetMeSeeNewsRepositoryImpl(private var items: LetMeSeeRemoteDataSource): LetMeSeeRepository {

    private var  articles : LetMeSeeEntity? = null

    override suspend fun getListofData(query: String): LetMeSeeEntity? {

        articles =  items.getSearch(queryParams = query)
       if(articles != null){

            articles?.articles?.map {
              it.publishedAt = it.publishedAt?.substring(0,10).toString()
              it.publishedAt = it.publishedAt?.replace("-","/")
          }
      }

        return articles
    }
}