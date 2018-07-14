package com.worldsnas.paginglibrarytest.ui

import android.arch.paging.PagedListAdapter
import android.view.ViewGroup
import com.worldsnas.paginglibrarytest.difutil.PhotoDiffUtilCallback
import com.worldsnas.paginglibrarytest.network.model.Photo
import com.worldsnas.paginglibrarytest.ui.photovh.PhotoViewHolder
import com.worldsnas.paginglibrarytest.ui.photovh.PhotoViewHolderFactory
import javax.inject.Inject

class PhotosAdapter @Inject constructor(photoDiffUtilCallback: PhotoDiffUtilCallback,
                                val photoViewHolderFactory: PhotoViewHolderFactory): PagedListAdapter<Photo, PhotoViewHolder>(photoDiffUtilCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return photoViewHolderFactory.create(parent)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.getVm().photoObj = getItem(position)
        holder.bind()
    }
}