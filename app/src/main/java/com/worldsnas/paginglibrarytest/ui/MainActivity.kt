package com.worldsnas.paginglibrarytest.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.worldsnas.paginglibrarytest.R
import com.worldsnas.paginglibrarytest.viewmodel.MainActivityViewModel
import com.worldsnas.paginglibrarytest.viewmodel.MainActivityViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: MainActivityViewModelFactory

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(MainActivityViewModel::class.java)

        initRecycler()
    }

    private fun initRecycler(){
        recyclerMainPhotoList.layoutManager = LinearLayoutManager(this)
    }
}
