package com.duyi.webviewdemo.scrollwebview

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

class FLWebView :WebView{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    var sizeChangeCallBack:((w: Int, h: Int, ow: Int, oh: Int)->Unit)? = null

    override fun onSizeChanged(w: Int, h: Int, ow: Int, oh: Int) {
        super.onSizeChanged(w, h, ow, oh)
        sizeChangeCallBack?.invoke(w, h, ow, oh)
    }
}