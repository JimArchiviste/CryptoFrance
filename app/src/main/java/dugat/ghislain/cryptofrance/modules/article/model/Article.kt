package dugat.ghislain.cryptofrance.modules.article.model

import android.os.Parcel
import android.os.Parcelable
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by Ghis on 20/03/2018.
 */
@Root(name = "item", strict = false)
class Article() : Parcelable {

    @field:Element(name = "title", required = false)
    var title: String? = null

    @field:Element(name = "description", required = false)
    var description: String? = null

    @field:Element
    var link: String? = null

    var image: String? = null

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        description = parcel.readString()
        link = parcel.readString()
        image = parcel.readString()
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(title)
        dest?.writeString(description)
        dest?.writeString(link)
        dest?.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

}