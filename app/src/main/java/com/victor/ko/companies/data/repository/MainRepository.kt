package com.victor.ko.companies.data.repository

import com.victor.ko.companies.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getCompanyList() = apiHelper.getCompanyList()

    suspend fun getCompanyDetail(id: String) = apiHelper.getCompanyDetail(id)

}