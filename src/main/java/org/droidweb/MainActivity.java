package org.droidweb;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main_layout);
    }

    @Override
    public void onStart() {
        super.onStart();
        
        // Get webview and enable js
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        
        // Add interface ('android' is the keyword that will be exposed in js)
        webView.addJavascriptInterface(new WebAppInterface(this), "android"); 
        
        // Load html file
        webView.loadUrl("file:///android_asset/index.html");
    }
    
    public class WebAppInterface {
        Context mContext;

        // Instantiate the interface and set the context
        WebAppInterface(Context c) {
            mContext = c;
        }

        // Show a toast from the web page
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }

}