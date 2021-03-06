package com.example.basel.hackernewsdemo.Adapter

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.graphics.drawable.Drawable
import com.example.basel.hackernewsdemo.R


class SimpleDividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val mDivider: Drawable

    init {
        mDivider = context.getResources().getDrawable(R.drawable.line_divider)
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }



}