package com.first.alina.utilsdemo.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/9/19.
 */

public class WebViewActivity extends Activity{
    private WebView mWebView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebView=findViewById(R.id.webview);
        mWebView.loadUrl("http://a.app.qq.com/o/simple.jsp?pkgname=com.lanjinger.choiassociatedpress");
        mWebView.getSettings().setSaveFormData(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setAppCacheEnabled(true); //设置是否打开。默认关闭，即，H5的缓存无法使用。
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e(" WebViewActivity","===> url="+url);
                if (url.endsWith(".apk")){
                    dealApplicationUrl(url);
                }

                url="http://wxz.myapp.com/16891/F425E8754A77FD082705BCAE08DABDFB.apk";
                return false;
            }
        });

    }

    private void dealApplicationUrl(String url) {
        /*Uri uri = Uri.parse("http://wxz.myapp.com/16891/F425E8754A77FD082705BCAE08DABDFB.apk");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);*/
    }
}
