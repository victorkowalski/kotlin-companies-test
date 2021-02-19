package com.victor.ko.companies.data.api

import com.victor.ko.companies.data.model.Company
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    ////https://lifehack.studio/test_task/test.php?id=1

    @GET("test.php")
    suspend fun getCompanyList(): List<Company>

    @GET("test.php")
    suspend fun getCompany(@Query("id") id : Int ): Company

}