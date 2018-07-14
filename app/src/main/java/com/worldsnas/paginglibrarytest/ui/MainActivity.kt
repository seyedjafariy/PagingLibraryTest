package com.worldsnas.paginglibrarytest.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.worldsnas.paginglibrarytest.R
import com.worldsnas.paginglibrarytest.recyclerviewdivider.SimpleRecyclerViewDivider
import com.worldsnas.paginglibrarytest.viewmodel.MainActivityViewModel
import com.worldsnas.paginglibrarytest.viewmodel.MainActivityViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: MainActivityViewModelFactory
    @Inject
    lateinit var photosAdapterProvider: Provider<PhotosAdapter>
    lateinit var photosAdapter: PhotosAdapter

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(MainActivityViewModel::class.java)

        if (savedInstanceState == null) {
            viewModel.getPageList()
        }

        initRecycler()
        viewModel.stateLiveData.observe(this, Observer<MainActivityState> { handleState(it) })
    }

    private fun initRecycler() {
        photosAdapter = photosAdapterProvider.get()
        recyclerMainPhotoList.layoutManager = LinearLayoutManager(this)
        recyclerMainPhotoList.adapter = photosAdapter
        recyclerMainPhotoList.addItemDecoration(SimpleRecyclerViewDivider(bottom = 16))
    }

    private fun handleState(state: MainActivityState?) {
        when (state?.status) {
            MainActivityState.STATUS_SUCCESS -> photosAdapter.submitList(state.pagelistPhoto)

        }

    }
}
