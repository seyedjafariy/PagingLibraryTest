package com.worldsnas.paginglibrarytest.app.network

import android.provider.Telephony.TextBasedSmsColumns.BODY
import com.worldsnas.paginglibrarytest.BuildConfig.DEBUG
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
object OkHttpModule {

    @JvmStatic
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Timber.d(message) }

        httpLoggingInterceptor.level = if (DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        return httpLoggingInterceptor
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {

        val builder = OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)// Set connection timeout
                .readTimeout(120, TimeUnit.SECONDS)// Read timeout
                .writeTimeout(120, TimeUnit.SECONDS)// Write timeout
                .addInterceptor(loggingInterceptor)

        return builder.build()

    }

}