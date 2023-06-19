package com.example.mycasino4.view.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.mycasino4.R
import com.example.mycasino4.constant.*
import kotlinx.android.synthetic.main.fragment_menu.*
import java.time.LocalDate


class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                MAIN.finishAffinity()
            }
        })
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        checkDayForAddCash()
        id_menu_tv_cash.text = MAIN.getMyCash().toString()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contextGame = "MENU"

        //загрузка картинок////////
        loadImageJackpot()
        loadImageBlackjack()
        loadImageRoulette()
        loadImageCash()
        ///////////////////////////

        id_menu_tv_blackjack.setOnClickListener {
            var bundle = Bundle()
            bundle.putString(GAME, BLACKJACK)
            MAIN.navController.navigate(R.id.action_menuFragment_to_loadingGameFragment,bundle)
        }

        id_menu_tv_jackpot.setOnClickListener {
            var bundle = Bundle()
            bundle.putString(GAME, JACKPOT)
            MAIN.navController.navigate(R.id.action_menuFragment_to_loadingGameFragment,bundle)
        }

        id_menu_tv_roulette.setOnClickListener {
            var bundle = Bundle()
            bundle.putString(GAME, ROULETTE)
            MAIN.navController.navigate(R.id.action_menuFragment_to_loadingGameFragment,bundle)
        }

        id_menu_exit.setOnClickListener {
            MAIN.finishAffinity()
        }

    }



    private fun loadImageJackpot(){
        Glide.with(requireContext())
            .load(url_image_menu_jackpot)
            .into(id_menu_img_jackpot)
    }
    private fun loadImageBlackjack(){
        Glide.with(requireContext())
            .load(url_image_menu_blackjack)
            .into(id_menu_img_blackjack)
    }
    private fun loadImageRoulette(){
        Glide.with(requireContext())
            .load(url_image_menu_roulette)
            .into(id_menu_img_roulette)
    }
    private fun loadImageCash(){
        Glide.with(requireContext())
            .load(url_image_cash)
            .into(id_menu_img_cash)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun checkDayForAddCash(){
        if(LocalDate.now().toString()!= MAIN.getLastDay()){
            MAIN.setCurrentDay(LocalDate.now().toString())
            MAIN.addCash(300)
        }
    }





}