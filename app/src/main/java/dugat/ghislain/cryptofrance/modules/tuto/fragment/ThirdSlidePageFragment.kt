package dugat.ghislain.cryptofrance.modules.tuto.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dugat.ghislain.cryptofrance.R
import dugat.ghislain.cryptofrance.modules.tuto.activity.TutoActivityViewInterface

/**
 * Created by Ghis on 22/03/2018.
 */
class ThirdSlidePageFragment : Fragment() {

    var listener: TutoActivityViewInterface? = null

    fun addListner(tutoActivityViewInterface: TutoActivityViewInterface) {
        listener = tutoActivityViewInterface
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_third_slide_page, container, false)
        val buttonClose = rootView.findViewById<Button>(R.id.close)
        buttonClose.setOnClickListener({
            listener?.onFinishTuto()
        })
        return rootView
    }

}
