package com.worldsnas.paginglibrarytest.app.network

import com.squareup.moshi.Moshi
import com.worldsnas.paginglibrarytest.network.Api
import com.worldsnas.paginglibrarytest.network.EndPoint
import com.worldsnas.paginglibrarytest.network.SchedulersFacade
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module(includes = arrayOf(OkHttpModule::class))
object NetworkModule {
    @JvmStatic
    @Provides
    fun provideTypeAdapter(): Moshi {
        return Moshi.Builder()
                .build()
    }


    @JvmStatic
    @Provides
    fun provideRestHelper(client: OkHttpClient, moshi: Moshi, scheduler: SchedulersFacade): Retrofit {
        return Retrofit.Builder()
                .baseUrl(EndPoint.BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler.io()))
                .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}