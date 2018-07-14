package com.worldsnas.paginglibrarytest.app.di

import com.worldsnas.paginglibrarytest.app.App
import com.worldsnas.paginglibrarytest.app.network.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class, AppModule::class, ActivityBuildersModule::class, AndroidSupportInjectionModule::class))
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract override fun build(): AppComponent
    }

    override fun inject(app: App)

}