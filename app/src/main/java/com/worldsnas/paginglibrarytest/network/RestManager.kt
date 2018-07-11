package com.worldsnas.paginglibrarytest.network

import com.worldsnas.paginglibrarytest.network.model.Photo
import io.reactivex.Observable
import javax.inject.Inject

class RestManager @Inject constructor() {

    @Inject
    lateinit var api: Api

    fun getPopularPhotos(page: Int = 1,
                         perPage: Int = 10,
                         orderBy: String = "popular"): Observable<List<Photo>> {
        return api.getPopularPhotos(page, perPage, orderBy)
    }

}