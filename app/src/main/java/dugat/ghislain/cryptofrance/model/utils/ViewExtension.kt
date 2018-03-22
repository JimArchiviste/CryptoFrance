package dugat.ghislain.cryptofrance.model.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Ghis on 20/03/2018.
 */

fun ViewGroup.inflate(resId: Int) : View {
    return LayoutInflater.from(context).inflate(resId, this, false)
}
