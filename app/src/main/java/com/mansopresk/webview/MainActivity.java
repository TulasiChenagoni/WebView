package com.mansopresk.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.simpleWebView);
    }

    public void staticHtml(View view)
    {
        String simpleHtml = "<html><body><h2> Hello... This is Tulasi</h2><h4> Good Morning</h4></body></html>";

        webView.loadData(simpleHtml, "text/html", "UTF-8");
    }

    public void loadWebPage(View view)
    {
        webView.setWebViewClient(new MyWebViewClient());
        String url = "http://www.google.com";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    public void loadPdf(View view)
    {
        webView.setWebViewClient(new MyWebViewClient());
        String pdf = "https://www.adobe.com/content/dam/acom/en/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);

    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
           // return super.shouldOverrideUrlLoading(view, request);
            view.loadUrl(url);
            return true;
        }
    }

}



