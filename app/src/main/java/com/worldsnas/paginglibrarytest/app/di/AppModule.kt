package com.worldsnas.paginglibrarytest.app.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
object AppModule {


    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}