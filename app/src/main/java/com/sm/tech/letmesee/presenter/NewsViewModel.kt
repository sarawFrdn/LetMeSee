package com.sm.tech.letmesee.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sm.tech.letmesee.domain.model.DataModel
import com.sm.tech.letmesee.domain.usecase.GetDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsViewModel(var getDataUseCase: GetDataUseCase): ViewModel(){

   private val _newsLiveData = MutableLiveData<List<DataModel>>()
    val newsLiveData : LiveData<List<DataModel>> = _newsLiveData


     fun getNewsList() {
        viewModelScope.launch(Dispatchers.IO) {
            _newsLiveData.postValue(getDataUseCase.getNews())
        }
    }
}