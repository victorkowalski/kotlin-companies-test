package com.victor.ko.companies.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Company {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("img")
    @Expose
    var img: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("lat")
    @Expose
    var lat: String? = null

    @SerializedName("lon")
    @Expose
    var lon: String? = null

    @SerializedName("www")
    @Expose
    var www: String? = null

    @SerializedName("phone")
    @Expose
    var phone: String? = null
}