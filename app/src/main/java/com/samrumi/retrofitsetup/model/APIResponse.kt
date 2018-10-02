package com.samrumi.retrofitsetup.model

class APIResponse {
    var apiResponse: Any? = null
    val error: Throwable?

    constructor(apiResponse: Any) {
        this.apiResponse = apiResponse
        this.error = null
    }

    constructor(error: Throwable) {
        this.error = error
        this.apiResponse = null
    }
}