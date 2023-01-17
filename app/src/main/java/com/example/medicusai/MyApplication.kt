package com.example.medicusai

//import com.example.medicusai.di.DaggerAppComponent
//import com.example.medicusai.di.DaggerAppComponent.factory
import android.app.Application
import com.example.medicusai.di.component.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class MyApplication: Application() ,HasAndroidInjector{
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
           return dispatchingAndroidInjector
    }
}