package com.worldsnas.paginglibrarytest

import android.arch.paging.PagedList
import com.worldsnas.paginglibrarytest.network.model.Photo
import javax.inject.Inject

class PhotoBoundryCallback @Inject constructor(): PagedList.BoundaryCallback<Photo>(){

    override fun onItemAtFrontLoaded(itemAtFront: Photo) {
        super.onItemAtFrontLoaded(itemAtFront)
    }
}