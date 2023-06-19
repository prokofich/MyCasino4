package com.example.mycasino4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.mycasino4.R
import com.example.mycasino4.constant.*
import kotlinx.android.synthetic.main.fragment_blackjack.*
import kotlinx.android.synthetic.main.fragment_roulette.*

class BlackjackFragment : Fragment() {

    var cashWin = 0

    var countCardsOpponent = 0



    var listMyCards = mutableListOf<String>()
    var listOpponentCards = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blackjack, container, false)
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)



    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contextGame = BLACKJACK

        loadImageBlackjack()
        loadImageCash()
        id_blackjack_tv_cash.text = MAIN.getMyCash().toString()

        id_blackjack_button_menu.setOnClickListener {
            MAIN.navController.navigate(R.id.action_blackjackFragment_to_menuFragment)
        }


        id_blackjack_go.setOnClickListener {
            if(checkMyCash()){

                MAIN.minusCash(50)
                id_blackjack_tv_cash.text = MAIN.getMyCash().toString()

                it.isVisible = false

                id_blackjack_btn_to_finish.isVisible = true
                id_blackjack_btn_take_card.isVisible = true

                id_blackjack_tv_your_cards.isVisible = true
                id_blackjack_tv_enemy_cards.isVisible = true

                id_blackjack_you_won.isVisible = true

                id_blackjack_ll_buttons.isVisible = true

                id_blackjack_tv_price.isVisible = false


                loadRandomCards()
                showCardsMyAndOpponent()

            }else{
                Toast.makeText(requireContext(),"you don't have enough money",Toast.LENGTH_SHORT).show()
            }
        }

        id_blackjack_btn_take_card.setOnClickListener {
            if(listMyCards.size!=4){
                listMyCards.add(listAllCard.shuffled()[1])

                when(listMyCards.size){
                    3 -> {
                        Glide.with(requireContext())
                            .load("http://37.27.9.28/11/"+listMyCards[2])
                            .into(id_me_blackjack3)
                    }
                    4 -> {
                        Glide.with(requireContext())
                            .load("http://37.27.9.28/11/"+listMyCards[3])
                            .into(id_me_blackjack4)
                    }
                }

            }else{
                //все карты взяты
                Toast.makeText(requireContext(),"you can't take more cards",Toast.LENGTH_SHORT).show()
            }

        }

        id_blackjack_btn_to_finish.setOnClickListener {
            showCardsOpponent()
            checkWin()
        }


    }

    private fun loadImageBlackjack(){
        Glide.with(requireContext())
            .load(url_image_blackjack)
            .into(id_blackjack_img)
    }

    private fun loadImageCash(){
        Glide.with(requireContext())
            .load(url_image_cash)
            .into(id_blackjack_img_cash)
    }

    private fun checkMyCash(): Boolean {
        return MAIN.getMyCash()>50
    }

    private fun loadRandomCards(){

        countCardsOpponent = listOf(2,2,3,3,3,3,4).shuffled()[1]
        when(countCardsOpponent){
            2 -> {
                for (i in 1..2){
                    listOpponentCards.add(listAllCard.shuffled()[1])
                }
            }
            3 -> {
                for (i in 1..3){
                    listOpponentCards.add(listAllCard.shuffled()[1])
                }
            }
            4 -> {
                for (i in 1..4){
                    listOpponentCards.add(listAllCard.shuffled()[1])
                }
            }
        }

        for(i in 1..2){
            listMyCards.add(listAllCard.shuffled()[1])
        }

    }

    private fun showCardsMyAndOpponent(){

        when(countCardsOpponent){
            2 -> {
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op1)
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op2)
                id_blackjack_op3.setImageDrawable(null)
                id_blackjack_op4.setImageDrawable(null)

            }
            3 -> {
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op1)
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op2)
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op3)
                id_blackjack_op4.setImageDrawable(null)
            }
            4 -> {
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op1)
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op2)
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op3)
                Glide.with(requireContext())
                    .load(url_obratnaya_card)
                    .into(id_blackjack_op4)
            }
        }

        Glide.with(requireContext())
            .load("http://37.27.9.28/11/"+listMyCards[0])
            .into(id_me_blackjack1)
        Glide.with(requireContext())
            .load("http://37.27.9.28/11/"+listMyCards[1])
            .into(id_me_blackjack2)
        id_me_blackjack3.setImageDrawable(null)
        id_me_blackjack4.setImageDrawable(null)

    }

    private fun showCardsOpponent(){
        when(countCardsOpponent){
            2 -> {
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[0])
                    .into(id_blackjack_op1)
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[1])
                    .into(id_blackjack_op2)
            }
            3 -> {
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[0])
                    .into(id_blackjack_op1)
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[1])
                    .into(id_blackjack_op2)
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[2])
                    .into(id_blackjack_op3)
            }
            4 -> {
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[0])
                    .into(id_blackjack_op1)
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[1])
                    .into(id_blackjack_op2)
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[2])
                    .into(id_blackjack_op3)
                Glide.with(requireContext())
                    .load("http://37.27.9.28/11/"+listOpponentCards[3])
                    .into(id_blackjack_op4)
            }
        }
    }

    private fun checkWin(){

        id_blackjack_btn_to_finish.isVisible = false
        id_blackjack_btn_take_card.isVisible = false

        id_blackjack_go.isVisible = true


        var summOpponent = 0
        var mySumm = 0

        for(i in listOpponentCards){
            summOpponent += mapAllCard[i]!!
        }

        for(i in listMyCards){
            mySumm+= mapAllCard[i]!!
        }

        if(summOpponent>21 && mySumm<=21){
            //победа
            win("victory!the opponent has too much")
        }else{
            if(summOpponent>21 && mySumm>21){
                //оба проиграли
                loss("both lost, everyone has too many points")
            }else{
                if(summOpponent==21 && mySumm==21){
                    //оба выиграли
                    win("a draw!the opponent also scored 21 points")
                }else{
                    if(summOpponent<=21 && mySumm>21){
                        //проигрыш
                        loss("you have lost, you have too many points")
                    }else{
                        if (summOpponent<21 && mySumm<21){
                            if(mySumm>summOpponent){
                                //победа
                                win("victory!you have more points")
                            }else{
                                //проигрыш
                                loss("you lost, the opponent scored more points")
                            }
                        }
                    }
                }
            }
        }

    }

    private fun win(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
        MAIN.addCash(100)
        id_blackjack_tv_cash.text = MAIN.getMyCash().toString()
        cashWin+=100
        id_blackjack_you_won.text = "you won $cashWin$"

        listMyCards = mutableListOf()
        listOpponentCards = mutableListOf()

    }

    private fun loss(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()

        listMyCards = mutableListOf()
        listOpponentCards = mutableListOf()

    }

}