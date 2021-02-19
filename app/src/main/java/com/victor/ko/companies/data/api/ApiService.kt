package com.victor.ko.companies.data.api

import com.victor.ko.companies.data.model.Company
import retrofit2.http.GET

interface ApiService {

    @GET("test.php")
    suspend fun getCompanyList(): List<Company>

}