package com.duyi.webviewdemo;

import android.webkit.WebView;

public class WebViewInjectJs {
    /**
     * 通过WebView向H5注入js代码
     *
     * @param webView
     */
    public static void injectJs(WebView webView, boolean isDayTheme) {

        // && isOnPageFinished
        if (isDayTheme) {
            //API19，android4.4及以下无法分开处理
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                webView.evaluateJavascript("document.body.style.backgroundColor=\"white\";document.body.style.color=\"black\";", null);
            } else {
                webView.loadUrl("javascript:document.body.style.backgroundColor=\"#white\";document.body.style.color=\"black\";");
            }
        } else if (!isDayTheme) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                webView.evaluateJavascript("document.body.style.backgroundColor=\"black\";document.body.style.color=\"white\";", null);
            } else {
                webView.loadUrl("javascript:document.body.style.backgroundColor=\"#black\";document.body.style.color=\"white\";");
            }
        }
    }
}
