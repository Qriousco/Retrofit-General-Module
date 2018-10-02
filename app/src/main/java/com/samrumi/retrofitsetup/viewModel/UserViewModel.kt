package com.samrumi.retrofitsetup.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samrumi.retrofitsetup.api.APIInterface
import com.samrumi.retrofitsetup.model.APIResponse
import com.samrumi.retrofitsetup.utils.performGETRequest
import retrofit2.Retrofit

class UserViewModel(private val retrofit: Retrofit) : ViewModel() {

    fun getPosts(): LiveData<APIResponse> {
        val postsAPIResponse = MutableLiveData<APIResponse>()
        val service = retrofit.create(APIInterface::class.java)
        performGETRequest(service.getPosts("2"),
                { response ->
                    postsAPIResponse.value = APIResponse(response)
                },
                { error ->
                    postsAPIResponse.value = APIResponse(error as Throwable)
                })
        return postsAPIResponse
    }
}