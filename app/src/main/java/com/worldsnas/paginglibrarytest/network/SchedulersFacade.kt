package com.worldsnas.paginglibrarytest.network

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulersFacade @Inject constructor() {

    fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }


    fun io(): Scheduler {
        return Schedulers.io()
    }

    fun computation(): Scheduler {
        return Schedulers.computation()
    }

    fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

}