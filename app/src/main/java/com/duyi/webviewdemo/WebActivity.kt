package com.duyi.webviewdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //设置javascript
        val webSettings = web.getSettings()
        webSettings.javaScriptEnabled = true

//        web.loadUrl("https://www.baidu.com/")
//        web.loadUrl("https://www.independent.co.uk/news/world/europe/glacier-funeral-switzerland-pivol-climate-change-global-warming-a9116046.html")
        web.loadUrl("https://heycar.m.autohome.com.cn/Flipboard/m/74976943-1.html")

//        web.loadUrl("https://post.smzdm.com/p/awxqz594/")
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        web.webViewClient = object:WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
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
    }
}
