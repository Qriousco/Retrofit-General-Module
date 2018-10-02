package com.samrumi.retrofitsetup.utils

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
  Performs a GET request
 */
fun performGETRequest(apiCallToBeMade: Call<Any>,
                      success: (response: Any) -> Unit,
                      error: (error: Any) -> Unit) {
    apiCallToBeMade.enqueue(object : Callback<Any> {
        override fun onFailure(call: Call<Any>, t: Throwable) {
            error(t)
        }

        override fun onResponse(call: Call<Any>, response: Response<Any>) {
            if (response.isSuccessful) {
                success(response.body()!!)
            } else {
                error(response.errorBody()!!)
            }
        }
    })
}


/*
  Performs a POST request
 */
fun performPOSTRequest(apiCallTobeMade: Call<ResponseBody>,
                       success: (response: Any) -> Unit,
                       error: (error: Any) -> Unit) {

    apiCallTobeMade.enqueue(object : Callback<ResponseBody> {
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            error(t)
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if (response.isSuccessful) {
                success(response.code())
            } else {
                error(response.errorBody()!!)
            }
        }
    })
}