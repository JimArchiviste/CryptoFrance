package dugat.ghislain.cryptofrance.modules.tuto.pager.presenter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Ghis on 22/03/2018.
 */
class TutoPagerAdapter(fm: FragmentManager, fragments: List<Fragment>): FragmentPagerAdapter(fm) {

    private val fragments: List<Fragment> = fragments

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int {
        return fragments.size
    }
}