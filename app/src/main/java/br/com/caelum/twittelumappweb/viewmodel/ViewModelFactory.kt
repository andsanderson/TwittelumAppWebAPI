package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.webclient.InicializadorDoRetrofit
import br.com.caelum.twittelumappweb.webclient.UsuarioWebClient

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val tweetRepository = TweetRepository()
    private val usuarioRepository = UsuarioRepository(UsuarioWebClient(InicializadorDoRetrofit.retrofit))

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.name == TweetViewModel::class.java.name) {
            modelClass.getConstructor(TweetRepository::class.java).newInstance(tweetRepository)
        } else {
            modelClass.getConstructor(UsuarioRepository::class.java).newInstance(usuarioRepository)
        }
    }


}