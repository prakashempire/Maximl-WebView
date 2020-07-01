package com.example.maximl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    ImageView ivSearch,ivhome;
    EditText etUrl;
    String url="https://google.com";
    private ProgressDialog progressDialog=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        progressDialog=new ProgressDialog(this);
        webView=findViewById(R.id.wvWebView);
        ivhome=findViewById(R.id.ivhome);
        ivSearch=findViewById(R.id.ivSearch);
        etUrl=findViewById(R.id.etUrl);

        webView.loadUrl(url);

        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDisplayZoomControls(false);
        settings.supportZoom();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        webView.clearHistory();
        webView.clearCache(true);


        ivhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(url);
            }
        });

        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=etUrl.getText().toString();
                webView.loadUrl(str);
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                progressDialog.setTitle("Please Wait...");
                progressDialog.setMessage("Website is Loading");
                progressDialog.show();
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();
                super.onPageFinished(view, url);

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}