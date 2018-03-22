package dugat.ghislain.cryptofrance.modules.mainactivity.fragments.home

import android.app.ActivityOptions
import android.content.Intent
import android.widget.ImageView
import dugat.ghislain.cryptofrance.home.fragment.presenter.HomePresenter
import dugat.ghislain.cryptofrance.modules.article.activities.ArticleImageActivity
import dugat.ghislain.cryptofrance.modules.article.fragment.ArticlesFragment
import dugat.ghislain.cryptofrance.modules.article.fragment.presenter.ArticlesPresenterInterface


class HomeFragment : ArticlesFragment() {

    override fun initializeFragmentPresenter(): ArticlesPresenterInterface {
        return HomePresenter(this)
    }


    override fun onSelectedArticle(imageArticle: ImageView?, image: String?) {
        val options = ActivityOptions.makeSceneTransitionAnimation(activity, imageArticle, "transition_img")
        val intent = Intent(context, ArticleImageActivity::class.java)
        intent.putExtra("image", image)
        startActivity(intent, options.toBundle())
    }
}