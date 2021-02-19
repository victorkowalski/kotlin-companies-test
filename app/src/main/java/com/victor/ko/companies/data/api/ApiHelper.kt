package com.victor.ko.companies.data.api

import retrofit2.http.Query

class ApiHelper(private val apiService: ApiService) {

    suspend fun getCompanyList() = apiService.getCompanyList()

    suspend fun getCompanyDetail(id: String) = apiService.getCompanyDetail(id)
}