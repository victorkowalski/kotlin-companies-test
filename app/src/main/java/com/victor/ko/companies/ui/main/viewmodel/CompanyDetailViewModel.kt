package com.victor.ko.companies.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.victor.ko.companies.data.repository.MainRepository
import com.victor.ko.companies.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay


class CompanyDetailViewModel(private val mainRepository: MainRepository/*, private var companyId: String*/) : ViewModel() {

    fun getCompanyDetail(companyId: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            delay(1000) // emulate long request
            emit(Resource.success(data = mainRepository.getCompanyDetail(companyId)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}