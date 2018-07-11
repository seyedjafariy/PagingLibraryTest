package com.worldsnas.paginglibrarytest.app.di

import com.worldsnas.paginglibrarytest.ui.MainActivity
import com.worldsnas.paginglibrarytest.ui.MainDi
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {


    @ContributesAndroidInjector(modules = arrayOf(MainDi::class))
    abstract fun bindMainActivity() : MainActivity

}