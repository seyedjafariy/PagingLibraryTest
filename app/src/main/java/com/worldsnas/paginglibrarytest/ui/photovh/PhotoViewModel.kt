package com.worldsnas.paginglibrarytest.ui.photovh

import com.worldsnas.paginglibrarytest.network.model.Photo

class PhotoViewModel {

    var photoObj : Photo? = null

    fun getPhotoUrl() : String?{
        return photoObj?.urls?.regular
    }
}