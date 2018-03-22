package dugat.ghislain.cryptofrance.model.services.firebase

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dugat.ghislain.cryptofrance.modules.article.activities.ArticleDetailActivity


/**
 * Created by Ghis on 21/03/2018.
 */
class ArticlesFirebaseMessagingService : FirebaseMessagingService() {
    private val TAG = "FCM Service"
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.
//        TODO("FAPFAP")
        val url = remoteMessage?.data?.get("url")
        val context = this.baseContext
        if(url != null){
            val intent = Intent(context, ArticleDetailActivity()::class.java)
            intent.putExtra("url", url)
            context.startActivity(intent)
        }
        Log.d(TAG, "From: " + remoteMessage!!.from)
        Log.d(TAG, "Notification Message Body: " + remoteMessage.notification?.body!!)
    }
}