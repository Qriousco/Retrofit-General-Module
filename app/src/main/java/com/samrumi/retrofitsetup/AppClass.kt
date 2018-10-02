package com.samrumi.retrofitsetup

import android.app.Application
import com.samrumi.retrofitsetup.utils.BASE_URL
import com.samrumi.retrofitsetup.viewModel.UserViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClass : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {

        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        bind() from provider { UserViewModelFactory(instance()) }
    }

}