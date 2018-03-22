package dugat.ghislain.cryptofrance.modules.article.viewlist.adapter

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.ViewGroup
import com.bumptech.glide.Glide
import dugat.ghislain.cryptofrance.*
import dugat.ghislain.cryptofrance.modules.article.model.Article
import dugat.ghislain.cryptofrance.modules.article.fragment.ArticlesSelectInterface
import dugat.ghislain.cryptofrance.modules.article.viewlist.holder.ArticleViewHolder
import dugat.ghislain.cryptofrance.model.utils.inflate

/**
 * Created by Ghis on 20/03/2018.
 */
class ArticlesAdapter(selectionInterface: ArticlesSelectInterface, var articles: ArrayList<Article>? = ArrayList()) : RecyclerView.Adapter<ArticleViewHolder>() {

    val selectionInterface: ArticlesSelectInterface = selectionInterface

    override fun getItemCount(): Int {
        return if(articles == null){
            0
        } else {
            articles!!.size
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val context = holder.itemView.context
        val article = articles?.get(position)
        val link = article?.link
        holder.title?.text = article?.title
        holder.description?.text = Html.fromHtml(article?.description, Html.FROM_HTML_MODE_COMPACT)
        Glide.with(context).load(article?.image).into(holder.imageArticle!!)
        if(link != null){
            holder.itemView.setOnClickListener({
                selectionInterface.onSelectedArticle(holder.imageArticle, article?.image)
//                val intent = Intent(context, ArticleDetailActivity()::class.java)
//                intent.putExtra("url", link)
//                context.startActivity(intent)
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = parent.inflate(R.layout.cell_article)
        return ArticleViewHolder(view)
    }

}