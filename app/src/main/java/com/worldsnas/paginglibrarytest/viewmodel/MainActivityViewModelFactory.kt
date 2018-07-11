package com.worldsnas.paginglibrarytest.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainActivityViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return mainActivityViewModel as T
    }
}