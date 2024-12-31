package com.walisaalam.class3.MovieApp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FrontViewModel: ViewModel() {
    lateinit var liveDataList: MutableLiveData<ArrayList<Item>>

    init {
        liveDataList  = MutableLiveData()
    }
    fun getLiveDataObserver(): MutableLiveData<ArrayList<Item>>{
        return liveDataList
    }
    fun makeApiCall(){
        viewModelScope.launch (Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi()
            liveDataList.postValue(response.results)
        }
    }

}