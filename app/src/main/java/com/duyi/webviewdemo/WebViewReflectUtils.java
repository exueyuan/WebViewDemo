package com.duyi.webviewdemo;

import android.content.Context;
import android.webkit.WebView;

import java.lang.reflect.Method;

public class WebViewReflectUtils {

    public static void webViewReflect(Context context, WebView webView) {
        try {

            webView.getSettings();
            Class clsWebSettingsClassic = context.getClassLoader().loadClass("android.webkit.WebSettingsClassic");
            Method md = clsWebSettingsClassic.getMethod(
                    "setProperty", String.class, String.class);
            md.invoke(webView.getSettings(), "inverted", "true");
            md.invoke(webView.getSettings(), "inverted_contrast", "1");
        } catch (Exception e) {
        }
    }
}
