package dugat.ghislain.cryptofrance.modules.article.fragment.presenter

import dugat.ghislain.cryptofrance.model.services.article.ArticlesReceivedCallback
import dugat.ghislain.cryptofrance.model.services.article.ArticlesService
import dugat.ghislain.cryptofrance.modules.article.fragment.ArticlesViewInterface
import dugat.ghislain.cryptofrance.modules.article.model.Article

/**
 * Created by Ghis on 22/03/2018.
 */
abstract class ArticlesPresenter(val viewCallbackInterface: ArticlesViewInterface) : ArticlesPresenterInterface {

    val service = ArticlesService()
    val serviceCallBack = object : ArticlesReceivedCallback {
        override fun onInternetError(error: String) {
            viewCallbackInterface.onError()
            viewCallbackInterface.onDismissDialog()
        }

        override fun onArticlesReceived(articles: ArrayList<Article>?) {
            viewCallbackInterface.onArticlesReceived(articles)
            viewCallbackInterface.onDismissDialog()
        }
    }

    override fun refreshArticlesList() {
        viewCallbackInterface.onShowDialog()
    }

}