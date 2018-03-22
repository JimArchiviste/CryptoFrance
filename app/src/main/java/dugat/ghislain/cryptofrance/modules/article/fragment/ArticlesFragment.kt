package dugat.ghislain.cryptofrance.modules.article.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import dugat.ghislain.cryptofrance.R
import dugat.ghislain.cryptofrance.modules.article.fragment.presenter.ArticlesPresenterInterface
import dugat.ghislain.cryptofrance.modules.article.model.Article
import dugat.ghislain.cryptofrance.modules.article.viewlist.adapter.ArticlesAdapter

/**
 * Created by Ghis on 22/03/2018.
 */
abstract class ArticlesFragment : Fragment(), ArticlesViewInterface, ArticlesSelectInterface {
    var presenter: ArticlesPresenterInterface? = null
    var articlesAdapter: ArticlesAdapter = ArticlesAdapter(this)
    private var pullToRefreshLayout: SwipeRefreshLayout? = null
    private var dialog: MaterialDialog? = null

    init {
        presenter = initializeFragmentPresenter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (articlesAdapter.articles?.size != 0) {
            outState?.putParcelableArrayList("current_articles", articlesAdapter.articles)
        }
    }

    abstract fun initializeFragmentPresenter(): ArticlesPresenterInterface

    override fun onArticlesReceived(articles: ArrayList<Article>?) {
        articlesAdapter.articles = articles
        articlesAdapter.notifyDataSetChanged()
        pullToRefreshLayout?.setRefreshing(false)
    }

    override fun onShowDialog() {
        val builder = MaterialDialog.Builder(this.context!!)
                .title("Chargement en cours")
                .content("Veuillez patienter")
                .progress(true, 0)
                .cancelable(false)
                .canceledOnTouchOutside(false)
        dialog = builder.build()
        dialog!!.show()
    }

    override fun onDismissDialog() {
        dialog?.dismiss()
    }

    override fun onSelectedArticle(imageArticle: ImageView?, image: String?) {

    }

    override fun onError() {
        Toast.makeText(context, "Une erreur s'est produite.",
                Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null){
            articlesAdapter.articles = savedInstanceState.getParcelableArrayList("current_articles")
            val test = "toto"
        }
        else {
            presenter?.refreshArticlesList()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_articles, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.articles_rv)
        pullToRefreshLayout = rootView.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        pullToRefreshLayout?.setRefreshing(false)
        pullToRefreshLayout?.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            // Your code to refresh the list here.
            // Make sure you call swipeContainer.setRefreshing(false)
            // once the network request has completed successfully.
            pullToRefreshLayout?.setRefreshing(false)
            presenter?.refreshArticlesList()
        })

        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = articlesAdapter
        return rootView
    }
}