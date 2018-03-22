package dugat.ghislain.cryptofrance.modules.tuto.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dugat.ghislain.cryptofrance.R

/**
 * Created by Ghis on 22/03/2018.
 */
class SecondSlidePageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(
                R.layout.fragment_second_slide_page, container, false) as ViewGroup
    }

}