package com.worldsnas.paginglibrarytest.viewmodel

import android.arch.lifecycle.ViewModel
import com.worldsnas.paginglibrarytest.network.RestManager
import com.worldsnas.paginglibrarytest.network.SchedulersFacade
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val restManager: RestManager, val schedulersFacade: SchedulersFacade): ViewModel() {



}