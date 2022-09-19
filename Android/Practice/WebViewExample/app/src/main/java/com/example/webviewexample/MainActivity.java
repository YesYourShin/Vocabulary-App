package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://m.naver.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // 자바 스크립트 허용
        webView.loadUrl(url); // 특정 url 주소를 틀어라
        webView.setWebChromeClient(new WebChromeClient()); // 크롬 세팅
        webView.setWebViewClient(new WebViewClientClass()); // 일반적인 클라이언트

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 다양한 안드로이드 키를 입력했을 때 어떤 동작을 해줘라
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { // 만약에 뒤로가기를 눌렀을 때 뒤로 갈 수 있게 되면
            webView.goBack();                                           // 웹뷰를 뒤로가게 해라
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient { //inner class 매인 액티비티에 만듦


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { // 현재 페이지의 url을 읽어올 수 있음
            view.loadUrl(url);
            return true;


        }
    }
}