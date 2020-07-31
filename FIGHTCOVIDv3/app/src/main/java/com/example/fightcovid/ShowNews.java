package com.example.fightcovid;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.KeyEvent;
        import android.view.View;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.Button;

public class ShowNews extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news);

            webView = (WebView) findViewById(R.id.web);
//            button = (Button) findViewById(R.id.button2);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    webView.setWebViewClient(new WebViewClient());
//                    webView.loadUrl("https://www.google.com/search?q=covid+19&rlz=1C1GCEA_enIN888IN889&sxsrf=ALeKk02V0ZysvuwoN6iqKj_4I5eRSB4e-g:1586178170501&source=lnms&tbm=nws&sa=X&ved=2ahUKEwj4xZyT7tPoAhXUzTgGHZoNAdwQ_AUoAXoECBYQAw&biw=1536&bih=722");
//                    WebSettings webSettings = webView.getSettings();
//                    webSettings.setJavaScriptEnabled(true);
//                }
//            });
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://news.google.com/topics/CAAqBwgKMMqAmAsw9KmvAw?hl=en-IN&gl=IN&ceid=IN%3Aen");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }

    public void onBackPressed() {
       if (webView.canGoBack()) {
           webView.goBack();
       } else {
           super.onBackPressed();
       }
   }


    }
