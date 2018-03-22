package dugat.ghislain.cryptofrance.modules.article.fragment

import dugat.ghislain.cryptofrance.modules.article.model.Article

/**
 * Created by Ghis on 21/03/2018.
 */
interface ArticlesViewInterface {
    fun onArticlesReceived(articles: ArrayList<Article>?)
    fun onShowDialog()
    fun onDismissDialog()
    fun onError()
}