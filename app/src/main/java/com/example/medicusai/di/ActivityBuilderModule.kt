package com.example.medicusai.di

import com.example.medicusai.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    internal abstract fun contributeMyActivity(): MainActivity
}