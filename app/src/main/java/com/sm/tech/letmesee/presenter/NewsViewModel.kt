package com.sm.tech.letmesee.presenter

import androidx.lifecycle.*
import com.sm.tech.letmesee.domain.model.DataModel
import com.sm.tech.letmesee.domain.usecase.GetDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsViewModel(private var getDataUseCase: GetDataUseCase): ViewModel(){

   private val _newsLiveData = MutableLiveData<DataModel?>()
    val newsLiveData : LiveData<DataModel?> = _newsLiveData

     fun getNewsList() {
        viewModelScope.launch {
            _newsLiveData.postValue(getDataUseCase.getNews())
        }
    }
}