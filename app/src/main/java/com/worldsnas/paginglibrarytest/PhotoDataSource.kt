package com.worldsnas.paginglibrarytest

import android.arch.paging.PageKeyedDataSource
import com.worldsnas.paginglibrarytest.network.RestManager
import com.worldsnas.paginglibrarytest.network.SchedulersFacade
import com.worldsnas.paginglibrarytest.network.model.Photo
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class PhotoDataSource @Inject constructor(val restManager: RestManager, val compositeDisposable: CompositeDisposable,
                                          val schedulersFacade: SchedulersFacade): PageKeyedDataSource<Int, Photo>() {

    override fun invalidate() {
        super.invalidate()
        compositeDisposable.clear()
        Timber.d("photo data source invalidate called")
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Photo>) {
        val disposable = restManager.getPopularPhotos(1, params.requestedLoadSize)
//                .onErrorReturnItem(emptyList())
                .subscribeOn(schedulersFacade.io())
                .subscribe({
                    callback.onResult(it, null, 2)
                }, {
                    Timber.e(it, "getting initial data in dataSource failed")
                })

        compositeDisposable.add(disposable)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        val disposable = restManager.getPopularPhotos(params.key, params.requestedLoadSize)
                .onErrorReturnItem(emptyList())
                .subscribeOn(schedulersFacade.io())
                .subscribe({
                    callback.onResult(it, params.key + 1)
                }, {
                    Timber.e(it, "getting initial data in dataSource failed")
                })

        compositeDisposable.add(disposable)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        //no response for before page 1
    }

}