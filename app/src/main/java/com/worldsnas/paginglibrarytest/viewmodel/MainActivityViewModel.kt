package com.worldsnas.paginglibrarytest.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import com.worldsnas.paginglibrarytest.PhotoDataSourceFactory
import com.worldsnas.paginglibrarytest.network.SchedulersFacade
import com.worldsnas.paginglibrarytest.network.model.Photo
import com.worldsnas.paginglibrarytest.ui.MainActivityState
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val photoDataSourceFactory: PhotoDataSourceFactory, val schedulersFacade: SchedulersFacade,
                                                val compositeDisposable: CompositeDisposable) : ViewModel() {
    private val config = PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(20).setPageSize(15).setPrefetchDistance(5).build()

    private val loadDataObservable = RxPagedListBuilder<Int, Photo>(photoDataSourceFactory, config)
            .setFetchScheduler(schedulersFacade.io())
            .setNotifyScheduler(schedulersFacade.ui())
            .buildObservable()

    val stateLiveData = MutableLiveData<MainActivityState>()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun getPageList() {
        val disposable = loadDataObservable
                .map {
                    MainActivityState(MainActivityState.STATUS_SUCCESS, it)
                }
                .subscribe({
                    stateLiveData.postValue(it)
                }, {
                    Timber.e(it, "load Data Observable failed")
                })

        compositeDisposable.add(disposable)
    }
}