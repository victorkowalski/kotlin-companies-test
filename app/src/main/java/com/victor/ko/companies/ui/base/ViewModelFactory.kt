package com.victor.ko.companies.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.victor.ko.companies.data.api.ApiHelper
import com.victor.ko.companies.data.repository.MainRepository
import com.victor.ko.companies.ui.main.viewmodel.CompanyDetailViewModel
import com.victor.ko.companies.ui.main.viewmodel.CompanyListViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompanyListViewModel::class.java)) {
            return CompanyListViewModel(MainRepository(apiHelper)) as T
        }

        if (modelClass.isAssignableFrom(CompanyDetailViewModel::class.java)) {
            return CompanyDetailViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

