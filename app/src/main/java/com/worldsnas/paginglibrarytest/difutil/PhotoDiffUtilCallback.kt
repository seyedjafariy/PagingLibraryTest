package com.worldsnas.paginglibrarytest.difutil

import android.support.v7.util.DiffUtil
import android.text.TextUtils
import com.worldsnas.paginglibrarytest.network.model.Photo
import javax.inject.Inject

class PhotoDiffUtilCallback @Inject constructor(): DiffUtil.ItemCallback<Photo>(){

    override fun areItemsTheSame(oldItem: Photo?, newItem: Photo?): Boolean {
        return TextUtils.equals(oldItem?.id , newItem?.id)
    }

    override fun areContentsTheSame(oldItem: Photo?, newItem: Photo?): Boolean {
        return TextUtils.equals(oldItem?.urls?.regular, newItem?.urls?.regular)
    }
}