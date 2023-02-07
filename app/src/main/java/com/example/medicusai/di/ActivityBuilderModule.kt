package com.example.medicusai.di

import com.example.medicusai.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
here you should insert each activity coressponding to its viewmodel
*/
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    internal abstract fun contributeMyActivity(): MainActivity
}