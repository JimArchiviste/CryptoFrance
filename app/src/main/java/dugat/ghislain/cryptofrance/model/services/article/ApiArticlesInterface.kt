package dugat.ghislain.cryptofrance.model.services.article

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Ghis on 20/03/2018.
 */

interface ApiArticlesInterface {

    @GET("/feed")
    fun getAllArticles(): Call<ArticlesObjectResponse>

    @GET("/bitcoin/feed")
    fun getBitcoinArticles(): Call<ArticlesObjectResponse>

    @GET("/ethereum/feed")
    fun getEthereumArticles(): Call<ArticlesObjectResponse>

}
