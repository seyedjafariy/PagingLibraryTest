package com.worldsnas.paginglibrarytest.network

import com.worldsnas.paginglibrarytest.network.model.Photo
import io.reactivex.Observable
import retrofit2.http.Query
import javax.inject.Inject

class RestManager @Inject constructor() {

    @Inject
    lateinit var api: Api

    fun getPopulartPhotos(page: Int = 1,
                          perPage: Int = 10,
                          orderBy: String = "popular"): Observable<List<Photo>> {
        return api.getPopulartPhotos(page, perPage, orderBy)
    }

}