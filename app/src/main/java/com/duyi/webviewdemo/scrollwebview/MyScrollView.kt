package com.duyi.webviewdemo.scrollwebview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

class MyScrollView :ScrollView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    var isNotIntercept = false

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return if (isNotIntercept) {
            false
        } else {
            super.onInterceptTouchEvent(ev)
        }
    }
}