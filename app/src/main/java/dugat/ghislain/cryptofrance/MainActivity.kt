package dugat.ghislain.cryptofrance

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.support.v4.view.GravityCompat
import dugat.ghislain.cryptofrance.modules.mainactivity.fragments.bitcoin.BitcoinFragment
import dugat.ghislain.cryptofrance.modules.mainactivity.fragments.home.HomeFragment
import dugat.ghislain.cryptofrance.modules.mainactivity.fragments.ethereum.EthereumFragment
import dugat.ghislain.cryptofrance.modules.mainactivity.presenter.MainPresenter
import dugat.ghislain.cryptofrance.modules.mainactivity.presenter.MainPresenterInterface
import dugat.ghislain.cryptofrance.modules.mainactivity.MainViewInterface
import dugat.ghislain.cryptofrance.model.preferences.PreferencesRepository
import dugat.ghislain.cryptofrance.modules.article.fragment.ArticlesFragment
import dugat.ghislain.cryptofrance.modules.tuto.activity.TutoActivity


class MainActivity : AppCompatActivity(), MainViewInterface {

    private var mDrawerLayout: DrawerLayout? = null
    private var presenter: MainPresenterInterface? = null
    private var fragments = mapOf<Int, ArticlesFragment>(
            R.id.nav_home to HomeFragment(),
            R.id.nav_bitcoin to BitcoinFragment(),
            R.id.nav_ethereum to EthereumFragment()
    )
    private var current_fragment = R.id.nav_home

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("current_fragment", current_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            current_fragment = savedInstanceState.getInt("current_fragment")
        }
        else{
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.content_frame, fragments[current_fragment])
            fragmentTransaction.commit()
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)

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
        navigationView.getMenu().findItem(current_fragment).setChecked(true)



        val repository = PreferencesRepository(PreferenceManager.getDefaultSharedPreferences(this))
        presenter = MainPresenter(this, repository)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onShowTuto() {
        startActivity(Intent(baseContext, TutoActivity::class.java))
    }

    private fun addFragment(item: MenuItem) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content_frame, fragments[item.itemId])
        fragmentTransaction.commit()
        current_fragment = item.itemId
    }

}
