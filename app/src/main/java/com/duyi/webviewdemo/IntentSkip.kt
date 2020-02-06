package com.duyi.webviewdemo

import android.content.Context
import android.content.Intent
import com.duyi.webviewdemo.scrollwebview.WebActivity

fun startWebActivity(context: Context, url:String?) {
    val intent = Intent(context, WebActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.putExtra(WebActivity.INTENT_URL, url)
    context.startActivity(intent)
}