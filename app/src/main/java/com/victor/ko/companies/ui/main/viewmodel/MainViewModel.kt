package com.victor.ko.companies.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.victor.ko.companies.data.repository.MainRepository
import com.victor.ko.companies.utils.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getCompanyList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getCompanyList()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}