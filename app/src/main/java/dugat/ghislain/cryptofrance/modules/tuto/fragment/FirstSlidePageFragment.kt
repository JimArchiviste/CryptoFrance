package dugat.ghislain.cryptofrance.modules.tuto.fragment

import android.view.ViewGroup
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import dugat.ghislain.cryptofrance.R


/**
 * Created by Ghis on 22/03/2018.
 */
class FirstSlidePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(
                R.layout.fragment_first_slide_page, container, false) as ViewGroup
    }

}