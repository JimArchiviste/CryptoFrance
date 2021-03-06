package dugat.ghislain.cryptofrance.model.services.firebase

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.iid.FirebaseInstanceId



/**
 * Created by Ghis on 21/03/2018.
 */
class FirebaseIDService: FirebaseInstanceIdService() {

    private val TAG = "FirebaseIDService"

    override fun onTokenRefresh() {
        // Get updated InstanceID token.
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refreshed token: " + refreshedToken!!)

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken)
    }

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private fun sendRegistrationToServer(token: String?) {
        // Add custom implementation, as needed.
    }

}