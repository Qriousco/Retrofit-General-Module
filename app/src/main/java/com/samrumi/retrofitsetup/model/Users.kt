package com.samrumi.retrofitsetup.model

import com.google.gson.annotations.SerializedName

data class Users(
        @SerializedName( "page") val page: String,
        @SerializedName( "per_page") val perPage: String,
        @SerializedName( "total") val total: String,
        @SerializedName( "total_pages") val totalPages: String,
        @SerializedName( "data") val data: ArrayList<UserData>)