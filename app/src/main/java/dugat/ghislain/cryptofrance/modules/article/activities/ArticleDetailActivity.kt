package dugat.ghislain.cryptofrance.modules.article.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import dugat.ghislain.cryptofrance.R


class ArticleDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        val articleWebView = findViewById<WebView>(R.id.webview)
        articleWebView
        val url = intent.extras.getString("url")
        articleWebView.loadUrl(url)
    }
}
