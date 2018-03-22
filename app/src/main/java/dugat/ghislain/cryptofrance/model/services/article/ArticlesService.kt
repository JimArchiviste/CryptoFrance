package dugat.ghislain.cryptofrance.model.services.article

import okhttp3.OkHttpClient
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit



/**
 * Created by Ghis on 20/03/2018.
 */

class ArticlesService {

    private var apiArticles: ApiArticlesInterface?

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.crypto-france.com")
                .client(OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
        apiArticles = retrofit.create(ApiArticlesInterface::class.java)
    }

    fun getAllArticles(callback: ArticlesReceivedCallback) {
        apiArticles?.getAllArticles()?.enqueue(object: Callback<ArticlesObjectResponse> {
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                callback.onInternetError(t.toString())
            }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                fetchArticles(callback, call, response)
            }

        })
    }

    fun getBitcoinArticles(callback: ArticlesReceivedCallback) {
        apiArticles?.getBitcoinArticles()?.enqueue(object: Callback<ArticlesObjectResponse> {
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                callback.onInternetError(t.toString())
            }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                fetchArticles(callback, call, response)
            }

        })
    }

    fun getEthereumArticles(callback: ArticlesReceivedCallback) {
        apiArticles?.getEthereumArticles()?.enqueue(object: Callback<ArticlesObjectResponse> {
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                callback.onInternetError(t.toString())
            }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                fetchArticles(callback, call, response)
            }

        })
    }

    private fun fetchArticles (callback: ArticlesReceivedCallback, call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
        var articles = response?.body()?.channel?.articles
        val image = response?.body()?.channel?.image
        articles?.forEach {
            it.image = image?.url
        }
        callback.onArticlesReceived(articles)
    }
}
