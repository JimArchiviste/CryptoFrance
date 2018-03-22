package dugat.ghislain.cryptofrance.model.services.article

import dugat.ghislain.cryptofrance.modules.article.model.Article

/**
 * Created by Ghis on 21/03/2018.
 */
interface ArticlesReceivedCallback {
    fun onArticlesReceived(articles: ArrayList<Article>?)
    fun onInternetError(error: String)
}