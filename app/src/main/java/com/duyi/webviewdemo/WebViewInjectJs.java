package com.duyi.webviewdemo;

import android.content.Context;
import android.util.Base64;
import android.webkit.WebView;

import java.io.InputStream;

public class WebViewInjectJs {

    public static void changeWebViewMode(Context context, WebView webView, boolean isDayTheme) {
        if (isDayTheme) {
//            webView.reload();
            try {
                InputStream is = context.getResources().openRawResource(R.raw.day);
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                is.close();
                String dayCode = Base64.encodeToString(buffer, Base64.NO_WRAP);
                webView.loadUrl(
                        "javascript:(function() {" + "var parent = document.getElementsByTagName('head').item(0);" + "var style = document.createElement('style');" + "style.type = 'text/css';" + "style.innerHTML = window.atob('" + dayCode + "');" + "parent.appendChild(style)" + "})();");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                InputStream is = context.getResources().openRawResource(R.raw.night);
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                is.close();
                String nightCode = Base64.encodeToString(buffer, Base64.NO_WRAP);
                webView.loadUrl(
                        "javascript:(function() {" + "var parent = document.getElementsByTagName('head').item(0);" + "var style = document.createElement('style');" + "style.type = 'text/css';" + "style.innerHTML = window.atob('" + nightCode + "');" + "parent.appendChild(style)" + "})();");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
