package com.duyi.webviewdemo

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.webkit.*
import kotlinx.android.synthetic.main.activity_normal_web.*
import java.lang.reflect.Method


class NormalWebActivity : AppCompatActivity() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_web)

        //设置javascript
        val webSettings = web.getSettings()
        webSettings.javaScriptEnabled = true

        bt_dark.setOnClickListener {
            WebViewInjectJs.changeWebViewMode(this, web, false)
        }

        bt_day.setOnClickListener {
            WebViewInjectJs.changeWebViewMode(this, web, true)
        }


/*        val url = "https://www.baidu.com/"
        web.loadUrl(url)*/

//        web.loadUrl("https://www.independent.co.uk/news/world/europe/glacier-funeral-switzerland-pivol-climate-change-global-warming-a9116046.html")
//        web.loadUrl("https://heycar.m.autohome.com.cn/Flipboard/m/74976943-1.html")

        web.loadUrl("https://mp.weixin.qq.com/s?__biz=MzI5MTczODI3Ng%3D%3D&chksm=ec0e54e2db79ddf4e4a30d639c7f46229016a0a763ad6de67f4b04e12596be7840cc4571e4bd&idx=1&mid=2247553833&scene=0&sn=41154e31aabe6c3390fccdac83ee60d3&xtrack=1#rd")

//        web.loadUrl("https://www.flipboard.cn/hybrid/articles/http%3A%2F%2Fm.happyjuzi.com%2Farticle%2F193166.html%3Fd_source%3Dflipboard%26pf%3Dandroid%26view%3D32?section_id=flipboard%2Fcurator%252Fmagazine%252FU6z-oRJ_QYSqF_vtoEstrw%253Am%253A995395684&section_subscribed=false")
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        web.webViewClient = object:WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

            }
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        web.webChromeClient = object :WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {

            }

        }

    }
}
