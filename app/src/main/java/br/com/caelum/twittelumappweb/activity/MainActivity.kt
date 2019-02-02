package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscadorDeTweetsFragmet
import br.com.caelum.twittelumappweb.fragment.ListaTweetsFragment
import br.com.caelum.twittelumappweb.fragment.MapaFragment
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var viewModel:TweetViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var  tweetViewModel: TweetViewModel
    private lateinit var  usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this,ViewModelFactory).get(TweetViewModel::class.java)

        usuarioViewModel = ViewModelProviders.of(this,ViewModelFactory).get(UsuarioViewModel::class.java)

        listenerBottomNavigation()

        bottom_navigation.selectedItemId = R.id.menu_tweets
        ftbAddTweet.setOnClickListener {startActivity(Intent(this, TweetActivity::class.java))}

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId==R.id.menu_sair){
            usuarioViewModel.desloga()
            voltaProLogin()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun voltaProLogin(){
        finish()
        startActivity(Intent(this,LoginActivity::class.java))
    }


    private fun listenerBottomNavigation(){
        bottom_navigation.setOnNavigationItemSelectedListener { item->

            when (item.itemId){
                R.id.menu_tweets->{
                    exibe(ListaTweetsFragment())
                    true
                }
                R.id.menu_busca->{
                    exibe(BuscadorDeTweetsFragmet())
                    true
                }
                R.id.menu_mapa->{
                    exibe(MapaFragment())
                    true
                }
                else->{
                    false
                }
            }
        }
    }

    private fun exibe (fragment: Fragment){
        val transacion = supportFragmentManager.beginTransaction()
        transacion.replace(R.id.frame_principal,fragment)
        transacion.commit()

    }
}
