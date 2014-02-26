package com.fererlab.LightGapAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;

import java.util.Random;

public class LGActivity extends Activity {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        WebView webView = (WebView) findViewById(R.id.webView);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieSyncManager syncManager = CookieSyncManager.createInstance(webView.getContext());
        syncManager.sync();

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        //webView.getSettings().setSupportMultipleWindows(true);
        //webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        //webView.getSettings().setAllowFileAccessFromFileURLs(true);
        //webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        //webView.addJavascriptInterface(this, "android");
        webView.getSettings().setDatabaseEnabled(true);
        //webView.getSettings().setDatabasePath("/data/data/" + getPackageName() + "/databases");

        webView.loadUrl("http://10.10.4.235/lg/index.html?" + new Random().nextDouble());

    }

}
