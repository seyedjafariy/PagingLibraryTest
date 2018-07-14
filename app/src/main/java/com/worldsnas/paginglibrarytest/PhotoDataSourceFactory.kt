package com.worldsnas.paginglibrarytest

import android.arch.paging.DataSource
import com.worldsnas.paginglibrarytest.network.model.Photo
import javax.inject.Inject
import javax.inject.Provider

class PhotoDataSourceFactory @Inject constructor(val photoDataSourceProvider: Provider<PhotoDataSource>) : DataSource.Factory<Int, Photo>() {

    override fun create(): DataSource<Int, Photo> {
        return photoDataSourceProvider.get()
    }
}