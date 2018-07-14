package com.worldsnas.paginglibrarytest.ui.photovh

import android.support.v7.widget.RecyclerView
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.worldsnas.paginglibrarytest.R

class PhotoViewHolder constructor(val view : View, private val vm : PhotoViewModel): RecyclerView.ViewHolder(view) {

    fun bind(){
        val image = view.findViewById(R.id.draweeRowPhoto) as SimpleDraweeView
        image.setImageURI(vm.getPhotoUrl())

    }

    fun getVm() : PhotoViewModel{
        return vm
    }
}