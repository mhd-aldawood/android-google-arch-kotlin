package com.example.medicusai.di.component

import com.example.medicusai.MyApplication
import com.example.medicusai.di.ActivityBuildersModule
import com.example.medicusai.di.ViewModelModule
import com.example.medicusai.network.RetrofitProvider
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        ViewModelModule::class,
        RetrofitProvider::class,
    ]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(myappliaction: MyApplication): Builder
        fun build(): AppComponent

    }

    fun inject(application: MyApplication)

}