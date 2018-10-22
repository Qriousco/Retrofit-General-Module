package com.samrumi.retrofitsetup.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samrumi.retrofitsetup.network.APIInterface
import com.samrumi.retrofitsetup.network.ApiResult
import com.samrumi.retrofitsetup.network.performGETRequest
import retrofit2.Retrofit

class UserViewModel(private val retrofit: Retrofit) : ViewModel() {

    fun getPosts(): LiveData<Any> {
        val postsAPIResponse = MutableLiveData<Any>()
        val service = retrofit.create(APIInterface::class.java)
        performGETRequest(service.getPosts("2"),
                { response ->
                    postsAPIResponse.value = ApiResult.Success(response)
                },
                { error ->
                    postsAPIResponse.value = ApiResult.Error(error as Throwable)
                })
        return postsAPIResponse
    }
}