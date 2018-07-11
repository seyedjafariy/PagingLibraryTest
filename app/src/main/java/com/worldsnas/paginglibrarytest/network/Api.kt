package com.worldsnas.paginglibrarytest.network

import com.worldsnas.paginglibrarytest.network.model.Photo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/photos")
    fun getPopulartPhotos(@Query("page") page: Int = 1,
                          @Query("per_page") perPage : Int = 10,
                          @Query("order_by") orderBy : String = "popular") : Observable<List<Photo>>
}