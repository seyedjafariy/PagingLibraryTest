package com.worldsnas.paginglibrarytest.ui.photovh

import android.view.LayoutInflater
import android.view.ViewGroup
import com.worldsnas.paginglibrarytest.R
import javax.inject.Inject

class PhotoViewHolderFactory @Inject constructor(){

    fun create(parent: ViewGroup) : PhotoViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_photo, parent, false);
        return PhotoViewHolder(view, PhotoViewModel())
    }
}