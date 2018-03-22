package dugat.ghislain.cryptofrance.model.services.article

import dugat.ghislain.cryptofrance.modules.article.model.Article
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by Ghis on 20/03/2018.
 */
@Root(name = "rss", strict = false)
class ArticlesObjectResponse {

    @field:Element(name = "channel", required = false)
    var channel: Channel? = null

    @Root(name = "channel", strict = false)
    class Channel {

        @field:ElementList(name = "item", required = false, inline = true)
        var articles: ArrayList<Article>? = null

        @field:Element(name = "image", required = false)
        var image: Image? = null
    }

    @Root(name = "image", strict = false)
    class Image {
        @field:Element(name = "url", required = false)
        var url: String? = null
    }

}
