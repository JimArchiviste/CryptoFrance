package dugat.ghislain.cryptofrance.modules.mainactivity.presenter

import dugat.ghislain.cryptofrance.modules.mainactivity.MainViewInterface
import dugat.ghislain.cryptofrance.model.preferences.PreferencesRepositoryInterface

/**
 * Created by Ghis on 22/03/2018.
 */

class MainPresenter(val viewCallback: MainViewInterface, repository: PreferencesRepositoryInterface) : MainPresenterInterface {
    init {
        if(!repository.hasReadTuto()){
            viewCallback.onShowTuto()
        }
    }
}
