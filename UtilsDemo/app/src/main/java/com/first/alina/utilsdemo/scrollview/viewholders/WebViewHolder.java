package com.first.alina.utilsdemo.scrollview.viewholders;

import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.scrollview.beans.TestWebBean;

/**
 * Created by alina on 2019/3/22.
 */
@BindLayout(R.layout.recycler_viewholder)
public class WebViewHolder extends ViewHolder<TestWebBean> {
    private final String TAG="WebViewHolder";
    private WebView mWebView;
    public WebViewHolder(View itemView) {
        super(itemView);
        mWebView=getView(R.id.webView);
        WebSettings webSettings = mWebView.getSettings();
        WebView.setWebContentsDebuggingEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setAllowContentAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setDomStorageEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.e(TAG,"view.getMeasuredHeight()="+view.getMeasuredHeight());
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        mWebView.loadUrl("http://172.16.30.249:8080/?mobile=15062213747&suid=4F30FD2DB1F51C63E055000000000001");
    }

    @Override
    public void setContent(TestWebBean item, int position) {


    }
}
