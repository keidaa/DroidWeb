package org.droidweb;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import android.content.Context;

public class HelloActivity extends Activity {
    private WebView wv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_layout);
        
        //get webview and enable js
        wv = (WebView) findViewById(R.id.web_view);
        wv.getSettings().setJavaScriptEnabled(true);
        
        //add interface
        wv.addJavascriptInterface(new WebAppInterface(this), "android");//android is the keyword that will be exposed in js
        
        //load file
        wv.loadUrl("file:///android_asset/test.html");
    }

    @Override
    public void onStart() {
        super.onStart();
        // LocalTime currentTime = new LocalTime();
        // TextView textView = (TextView) findViewById(R.id.text_view);
        // textView.setText("The current local time is: " + currentTime);
    }
    
    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }

}