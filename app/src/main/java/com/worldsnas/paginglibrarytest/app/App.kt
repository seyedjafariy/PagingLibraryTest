package com.worldsnas.paginglibrarytest.app

import android.app.Activity
import com.facebook.drawee.backends.pipeline.Fresco
import com.worldsnas.paginglibrarytest.BuildConfig.DEBUG
import com.worldsnas.paginglibrarytest.app.di.AppModule
import com.worldsnas.paginglibrarytest.app.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject


class App : DaggerApplication() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
//    @Inject
//    var mRestManager: RestManager? = null


    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        if (DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().moudle(AppModule).create(this)
    }
}