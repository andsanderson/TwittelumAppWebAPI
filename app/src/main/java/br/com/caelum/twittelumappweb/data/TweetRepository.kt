package br.com.caelum.twittelumappweb.data

import android.arch.lifecycle.MutableLiveData
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.webclient.TweetWebClient
import br.com.caelum.twittelumappweb.webclient.UsuarioWebClient

class TweetRepository(private val client: TweetWebClient) {

    fun salva(tweet: Tweet) {client.salva(tweet)}

    val lista: MutableLiveData<List<Tweet>> = MutableLiveData()

    fun busca()
    {
        client.buscaTweets ( sucesso() )
    }

    private fun sucesso()={list:List<Tweet>->
        lista.value = list
    }

}