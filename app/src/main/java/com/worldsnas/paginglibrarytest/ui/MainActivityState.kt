package com.worldsnas.paginglibrarytest.ui

import android.arch.paging.PagedList
import com.worldsnas.paginglibrarytest.network.model.Photo

class MainActivityState constructor(val status : Int, val pagelistPhoto : PagedList<Photo>){

    companion object {
        const val STATUS_SUCCESS = 1005
    }
}