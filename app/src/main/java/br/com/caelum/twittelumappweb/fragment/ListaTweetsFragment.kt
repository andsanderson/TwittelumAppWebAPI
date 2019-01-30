package br.com.caelum.twittelumappweb.fragment


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.lista_tweet_fragment.view.*

class ListaTweetsFragment: Fragment(){

    private lateinit var  viewModel:TweetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel= ViewModelProviders.of(activity!!,ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.lista_tweet_fragment, container, false)

        val tweets = viewModel.tweets()

        view.lista_tweet.adapter= TweetAdapter(tweets)



        return view
    }
}