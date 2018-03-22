package dugat.ghislain.cryptofrance.modules.article.viewlist.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import dugat.ghislain.cryptofrance.R

/**
 * Created by Ghis on 20/03/2018.
 */

class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    var imageArticle: ImageView? = itemView.findViewById(R.id.article_imv)
    var title: TextView? = itemView.findViewById(R.id.articles_title)
    var description: TextView? = itemView.findViewById(R.id.articles_details)

}
