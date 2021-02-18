package com.victor.ko.companies.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getCompanyList() = apiService.getCompanyList()
}