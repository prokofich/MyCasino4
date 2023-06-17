package com.example.mycasino4.view.fragments

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mycasino4.R
import com.example.mycasino4.constant.*
import kotlinx.android.synthetic.main.fragment_loading_game.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingGameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loading_game, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var game = requireArguments().getString(GAME)

        when(game){
            BLACKJACK -> {
                id_loadinggame.setBackgroundResource(R.color.color_blackjack)
                loadImageLoading(url_image_loaing_blackjack)
                id_loadinggame_message.text = loading_message_blackjack
            }
            JACKPOT -> {
                id_loadinggame.setBackgroundResource(R.color.color_jackpot)
                loadImageLoading(url_image_loading_jackpot)
                id_loadinggame_message.text = loading_message_jackpot
            }
            ROULETTE -> {
                id_loadinggame.setBackgroundResource(R.color.color_roulette)
                loadImageLoading(url_image_loading_roulette)
                id_loadinggame_message.text = loading_message_roulette
            }
        }

        id_loading_button_next.setOnClickListener {
            when(game){
                BLACKJACK -> { MAIN.navController.navigate(R.id.action_loadingGameFragment_to_blackjackFragment) }
                JACKPOT -> { MAIN.navController.navigate(R.id.action_loadingGameFragment_to_jackpotFragment) }
                ROULETTE -> { MAIN.navController.navigate(R.id.action_loadingGameFragment_to_rouletteFragment) }
            }
        }

    }

    private fun loadImageLoading(url:String){
        Glide.with(requireContext())
            .load(url)
            .into(id_loadinggame_img)
    }

}