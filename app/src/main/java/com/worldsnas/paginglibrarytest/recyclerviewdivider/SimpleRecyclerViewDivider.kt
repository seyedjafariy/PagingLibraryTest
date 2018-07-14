package com.worldsnas.paginglibrarytest.recyclerviewdivider

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SimpleRecyclerViewDivider constructor(val left: Int = 0, val right: Int = 0,
                                            val top: Int = 0, val bottom: Int = 0) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        outRect?.top = top
        outRect?.right = right
        outRect?.left = left
        outRect?.bottom = bottom
    }
}