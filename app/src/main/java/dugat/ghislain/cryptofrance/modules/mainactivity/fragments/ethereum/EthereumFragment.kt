package dugat.ghislain.cryptofrance.modules.mainactivity.fragments.ethereum

import android.app.ActivityOptions
import android.content.Intent
import android.widget.ImageView
import dugat.ghislain.cryptofrance.modules.article.activities.ArticleImageActivity
import dugat.ghislain.cryptofrance.modules.article.fragment.presenter.ArticlesPresenterInterface
import dugat.ghislain.cryptofrance.ethereum.fragment.presenter.EthereumPresenter
import dugat.ghislain.cryptofrance.modules.article.fragment.ArticlesFragment

class EthereumFragment : ArticlesFragment() {

    override fun initializeFragmentPresenter(): ArticlesPresenterInterface {
        return EthereumPresenter(this)
    }

    override fun onSelectedArticle(imageArticle: ImageView?, image: String?) {
        val options = ActivityOptions.makeSceneTransitionAnimation(activity, imageArticle, "transition_img")
        val intent = Intent(context, ArticleImageActivity::class.java)
        intent.putExtra("image", image)
        startActivity(intent, options.toBundle())
    }
}