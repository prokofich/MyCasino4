package com.example.mycasino4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mycasino4.R
import com.example.mycasino4.constant.MAIN
import com.example.mycasino4.constant.listNumberForJackpot
import com.example.mycasino4.constant.url_image_cash
import com.example.mycasino4.constant.url_image_jackpot
import kotlinx.android.synthetic.main.fragment_jackpot.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JackpotFragment : Fragment() {

    var number_1_for_jackpot = 0
    var number_2_for_jackpot = 0
    var number_3_for_jackpot = 0

    var myCashWin = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jackpot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadImageJackpot()
        loadImageCash()

        id_jackpot_tv_cash.text = MAIN.getMyCash().toString()

        id_jackpot_button_menu.setOnClickListener {
            MAIN.navController.navigate(R.id.action_jackpotFragment_to_menuFragment)
        }

        id_jackpot_button_go.setOnClickListener {
            if(checkMyCash()){
                MAIN.minusCash(20)
                it.isEnabled = false
                getRandomNumberForJackpot()
                showNumberForJackpot()
            }else{
                Toast.makeText(requireContext(),"you don't have enough money",Toast.LENGTH_SHORT).show()
            }

        }





    }

    private fun loadImageJackpot(){
        Glide.with(requireContext())
            .load(url_image_jackpot)
            .into(id_jackpot_img)
    }

    private fun loadImageCash(){
        Glide.with(requireContext())
            .load(url_image_cash)
            .into(id_jackpot_img_cash)
    }

    private fun showNumberForJackpot(){
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            id_jackpot_window_1.text = number_1_for_jackpot.toString()
            delay(1000)
            id_jackpot_window_2.text = number_2_for_jackpot.toString()
            delay(1000)
            id_jackpot_window_3.text = number_3_for_jackpot.toString()
            checkJackpotWin()
            id_jackpot_tv_cash.text = MAIN.getMyCash().toString()
            delay(2000)
            id_jackpot_window_1.text = "-"
            id_jackpot_window_2.text = "-"
            id_jackpot_window_3.text = "-"
            id_jackpot_button_go.isEnabled = true
        }
    }

    private fun getRandomNumberForJackpot(){
        number_1_for_jackpot = listNumberForJackpot.shuffled()[1]
        number_2_for_jackpot = listNumberForJackpot.shuffled()[1]
        number_3_for_jackpot = listNumberForJackpot.shuffled()[1]
    }

    private fun checkJackpotWin(){
        if(number_1_for_jackpot == number_2_for_jackpot && number_2_for_jackpot == number_3_for_jackpot){
            Toast.makeText(requireContext(),"!JACKPOT!+200$",Toast.LENGTH_SHORT).show()
            MAIN.addCash(200)
            myCashWin+=200
            id_jackpot_you_won.text = "you won $myCashWin$"
            id_jackpot_tv_cash.text = MAIN.getMyCash().toString()
        }else{
            Toast.makeText(requireContext(),"you've lost",Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkMyCash(): Boolean {
        return MAIN.getMyCash()>20
    }

}