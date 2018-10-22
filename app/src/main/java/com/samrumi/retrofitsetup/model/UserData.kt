package com.samrumi.retrofitsetup.model

import com.google.gson.annotations.SerializedName

data class UserData(
        @SerializedName("id") val id: Int,
        @SerializedName("first_name") val firstName: String,
        @SerializedName("last_name") val lastName: String,
        @SerializedName("avatar") val avatar: String)
