package dugat.ghislain.cryptofrance.modules.article.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import dugat.ghislain.cryptofrance.R
import android.util.DisplayMetrics
import android.support.design.widget.Snackbar


/**
 * Created by Ghis on 22/03/2018.
 */
class ArticleImageActivity : AppCompatActivity() {

    var imageArticle: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_image)
        imageArticle = findViewById<ImageView>(R.id.image_full)
        val image = intent.extras.getString("image")
        Glide.with(baseContext).load(image).into(imageArticle)

        val button = findViewById<Button>(R.id.transition_button)

        button.setOnClickListener({
            val metrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(metrics)
            imageArticle?.animate()?.translationY(400.0f * metrics.density)
            val mySnackbar = Snackbar.make(findViewById(android.R.id.content),
                    "TEST", Snackbar.LENGTH_SHORT)
            mySnackbar.show()
        })

    }
}