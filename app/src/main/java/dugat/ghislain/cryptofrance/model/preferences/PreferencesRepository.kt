package dugat.ghislain.cryptofrance.model.preferences

import android.content.SharedPreferences

interface PreferencesRepositoryInterface {
    fun hasReadTuto(): Boolean
    fun setHasReadTuto()
}

/**
 * Created by Ghis on 22/03/2018.
 */
class PreferencesRepository(pref: SharedPreferences): PreferencesRepositoryInterface {

    val HAS_READ_TUTO: Boolean = pref.getBoolean("hasReadTuto", false)
    val pref = pref

    override fun hasReadTuto(): Boolean {
        return HAS_READ_TUTO
    }

    override fun setHasReadTuto() {
        val editor  = pref.edit()
        editor.putBoolean("hasReadTuto", true)
        editor.apply()
    }

}