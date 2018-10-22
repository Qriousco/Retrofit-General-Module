package com.samrumi.retrofitsetup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.samrumi.retrofitsetup.adapter.PostAdapter
import com.samrumi.retrofitsetup.model.UserData
import com.samrumi.retrofitsetup.model.Users
import com.samrumi.retrofitsetup.network.ApiResult
import com.samrumi.retrofitsetup.viewModel.UserViewModel
import com.samrumi.retrofitsetup.viewModel.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import com.samrumi.retrofitsetup.R

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    private val postViewModelFactory: UserViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postViewModel = ViewModelProviders.of(this@MainActivity, postViewModelFactory)
                .get(UserViewModel::class.java)
        postViewModel.getPosts().observe(this@MainActivity, Observer {
            if (it is ApiResult.Success<*>) {
                //handle the data response
                val userResponseObject = Gson().fromJson(Gson().toJson((it.data)),
                        Users::class.java)
                handleAPIResponse(userResponseObject.data)
            } else {
                //handle the error
                handlerError()
            }
        })
    }

    private fun handleAPIResponse(postList: List<UserData>?) {
        rv_posts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL,
                    false)
            adapter = PostAdapter(this@MainActivity, postList!!)
            hideProgress()
        }
    }

    private fun hideProgress() {
        progress_main.visibility = View.GONE
    }

    private fun handlerError() {
        toast("Error occurred")
    }

}
