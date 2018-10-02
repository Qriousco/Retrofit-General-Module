package com.samrumi.retrofitsetup.model

import com.google.gson.annotations.SerializedName

data class Users(
        @SerializedName("page")
        val page: String,

        @SerializedName("per_page")
        val per_page: String,

        @SerializedName("total")
        val total: String,

        @SerializedName("total_pages")
        val total_pages: String,

        @SerializedName("data")
        val data: ArrayList<UserData>)