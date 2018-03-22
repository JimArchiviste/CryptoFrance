package dugat.ghislain.cryptofrance.modules.tuto.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import dugat.ghislain.cryptofrance.R
import dugat.ghislain.cryptofrance.modules.mainactivity.fragments.bitcoin.BitcoinFragment
import dugat.ghislain.cryptofrance.modules.mainactivity.fragments.ethereum.EthereumFragment
import dugat.ghislain.cryptofrance.modules.mainactivity.fragments.home.HomeFragment
import android.support.v4.view.ViewPager
import android.support.v4.view.PagerAdapter
import dugat.ghislain.cryptofrance.model.preferences.PreferencesRepository
import dugat.ghislain.cryptofrance.modules.tuto.pager.presenter.TutoPagerAdapter
import dugat.ghislain.cryptofrance.modules.tuto.fragment.FirstSlidePageFragment
import dugat.ghislain.cryptofrance.modules.tuto.fragment.SecondSlidePageFragment
import dugat.ghislain.cryptofrance.modules.tuto.fragment.ThirdSlidePageFragment
import java.util.*

class TutoActivity : AppCompatActivity(), TutoActivityViewInterface {

    private var mDrawerLayout: DrawerLayout? = null
    private var mPagerAdapter: PagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuto)

        mDrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            if(!menuItem.isChecked){
                menuItem.isChecked = true
                addFragment(menuItem)
            }
            // close drawer when item is tapped
            mDrawerLayout?.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }

        // Création de la liste de Fragments que fera défiler le PagerAdapter
        val fragments = Vector<Fragment>()

        // Ajout des Fragments dans la liste
        fragments.add(FirstSlidePageFragment())
        fragments.add(SecondSlidePageFragment())

        val lastFragment = ThirdSlidePageFragment()
        lastFragment.addListner(this)
        fragments.add(lastFragment)

        // Création de l'adapter qui s'occupera de l'affichage de la liste de
        // Fragments
        mPagerAdapter = TutoPagerAdapter(super.getSupportFragmentManager(), fragments)

        val pager = findViewById<ViewPager>(R.id.viewpager)
        // Affectation de l'adapter au ViewPager
        pager.adapter = this.mPagerAdapter

    }

    override fun onFinishTuto() {
        val repository = PreferencesRepository(PreferenceManager.getDefaultSharedPreferences(this))
        repository.setHasReadTuto()
        finish()
    }

    private fun addFragment(item: MenuItem) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.nav_home -> {
                fragmentTransaction.replace(R.id.content_frame, HomeFragment())
            }
            R.id.nav_bitcoin -> {
                fragmentTransaction.replace(R.id.content_frame, BitcoinFragment())
            }
            R.id.nav_ethereum -> {
                fragmentTransaction.replace(R.id.content_frame, EthereumFragment())
            }

        }
        fragmentTransaction.commit()
    }

}
