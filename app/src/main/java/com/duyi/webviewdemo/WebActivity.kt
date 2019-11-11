package com.duyi.webviewdemo

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.webkit.*
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        fl_root.viewTreeObserver.addOnGlobalLayoutListener(object :ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    fl_root.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
                val param = web.layoutParams
                param.height = fl_root.height
                web.layoutParams = param
                scrollview.isNotIntercept = true
            }
        })


        //设置javascript
        val webSettings = web.getSettings()
        webSettings.javaScriptEnabled = true

        web.loadUrl("https://www.baidu.com/")
//        web.loadUrl("https://www.independent.co.uk/news/world/europe/glacier-funeral-switzerland-pivol-climate-change-global-warming-a9116046.html")
//        web.loadUrl("https://heycar.m.autohome.com.cn/Flipboard/m/74976943-1.html")

//        web.loadUrl("https://post.smzdm.com/p/awxqz594/")
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        web.webViewClient = object:WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                val param = web.layoutParams
                param.height = ViewGroup.LayoutParams.MATCH_PARENT
                web.layoutParams = param
                scrollview.isNotIntercept = false
            }
        }

        web.webChromeClient = object :WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if(newProgress < 100) {
                    val progress = "进度：$newProgress%"
                    tv_progress.text = progress
                } else {
                    tv_progress.text = "进度：100%"
                }
            }
        }

        web.sizeChangeCallBack = { w: Int, h: Int, ow: Int, oh: Int ->

            Log.i("hahahhah","w:$w,h:$h")
        }
    }
}
