package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {

    fun tweets() = repository.lista

    fun salva(tweet: Tweet) = repository.salva(tweet)

    fun buscaTweets() = repository.busca()

}