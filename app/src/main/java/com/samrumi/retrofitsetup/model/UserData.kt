package com.samrumi.retrofitsetup.model

import com.google.gson.annotations.SerializedName

data class UserData(
        @SerializedName("id")
        var id: Int,

        @SerializedName("first_name")
        var first_name: String,

        @SerializedName("last_name")
        var last_name: String,

        @SerializedName("avatar")
        var avatar: String)