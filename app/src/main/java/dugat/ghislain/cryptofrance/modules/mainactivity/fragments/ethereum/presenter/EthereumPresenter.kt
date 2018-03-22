package dugat.ghislain.cryptofrance.ethereum.fragment.presenter

import dugat.ghislain.cryptofrance.modules.article.fragment.ArticlesViewInterface
import dugat.ghislain.cryptofrance.modules.article.fragment.presenter.ArticlesPresenter

/**
 * Created by Ghis on 20/03/2018.
 */
class EthereumPresenter(viewCallbackInterface: ArticlesViewInterface) : ArticlesPresenter(viewCallbackInterface) {

    override fun refreshArticlesList() {
        super.refreshArticlesList()
        service.getEthereumArticles(serviceCallBack)
    }
}