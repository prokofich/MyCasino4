package com.example.mycasino4.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mycasino4.R
import com.example.mycasino4.constant.*
import kotlinx.android.synthetic.main.fragment_roulette.*
import kotlinx.coroutines.*

class RouletteFragment : Fragment() {

    var corJob1:Job = Job()
    var corJob2:Job = Job()
    var corJob3:Job = Job()
    var corJob4:Job = Job()
    var corJob5:Job = Job()
    var corJob6:Job = Job()

    var roulettePoints = 0
    var cashWin = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_roulette, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contextGame = ROULETTE

        val p1 = id_roulette_1
        val p2 = id_roulette_2
        val p3 = id_roulette_3
        val p4 = id_roulette_4
        val p5 = id_roulette_5
        val p6 = id_roulette_6
        val p7 = id_roulette_7
        val p8 = id_roulette_8
        val p9 = id_roulette_9
        val p10 = id_roulette_10
        val p11 = id_roulette_11
        val p12 = id_roulette_12
        val p13 = id_roulette_13
        val p14 = id_roulette_14
        val p15 = id_roulette_15
        val p16 = id_roulette_16
        val p17 = id_roulette_17
        val p18 = id_roulette_18
        val p19 = id_roulette_19
        val p20 = id_roulette_20
        val p21 = id_roulette_21
        val p22 = id_roulette_22
        val p23 = id_roulette_23
        val p24 = id_roulette_24
        val p25 = id_roulette_25
        val p26 = id_roulette_26
        val p27 = id_roulette_27
        val p28 = id_roulette_28
        val p29 = id_roulette_29
        val p30 = id_roulette_30
        val p31 = id_roulette_31
        val p32 = id_roulette_32
        val p33 = id_roulette_33
        val p34 = id_roulette_34
        val p35 = id_roulette_35
        val p36 = id_roulette_36

        var listP = listOf<TextView>(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20
        ,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36)

        for (i in listP){
            i.setOnClickListener {

                showPoint()

                corJob1 = CoroutineScope(Dispatchers.Main).launch {
                    if(i.text.toString().toInt()==roulettePoints){
                        MAIN.addCash(1000)
                        id_roulette_tv_cash.text = MAIN.getMyCash().toString()
                        id_roulette_tv_you_won.text = "you win $cashWin$"
                        Toast.makeText(requireContext(),"!you guessed right! +1000$",Toast.LENGTH_SHORT).show()
                        i.setBackgroundResource(R.color.color_green_roulette)
                        delay(2000)
                        if(i.text.toString().toInt() in listRouletteRed){
                            i.setBackgroundResource(R.color.color_roulette)
                            Toast.makeText(requireContext(),"select any of the buttons again",Toast.LENGTH_SHORT).show()
                        }else{
                            i.setBackgroundResource(R.color.black)
                            Toast.makeText(requireContext(),"select any of the buttons again",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
                        i.setBackgroundResource(R.color.color_gray_roulette)
                        delay(2000)
                        if(i.text.toString().toInt() in listRouletteRed){
                            i.setBackgroundResource(R.color.color_roulette)
                            Toast.makeText(requireContext(),"select any of the buttons again",Toast.LENGTH_SHORT).show()
                        }else{
                            i.setBackgroundResource(R.color.black)
                            Toast.makeText(requireContext(),"select any of the buttons again",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                for(i in listP){
                    i.isEnabled = false
                }
            }
        }

        Toast.makeText(requireContext(),"click on any of the 5 buttons",Toast.LENGTH_SHORT).show()

        loadImageCash()
        id_roulette_tv_cash.text = MAIN.getMyCash().toString()

        id_roulette_button_menu.setOnClickListener {
            if(corJob1.isActive){
                corJob1.cancel()
            }
            if(corJob2.isActive){
                corJob2.cancel()
            }
            if(corJob3.isActive){
                corJob3.cancel()
            }
            if(corJob4.isActive){
                corJob4.cancel()
            }
            if(corJob5.isActive){
                corJob5.cancel()
            }
            if(corJob6.isActive){
                corJob6.cancel()
            }
            MAIN.navController.navigate(R.id.action_rouletteFragment_to_menuFragment)
        }

        id_roulette_btn_even.setOnClickListener {
            if(checkMyCash()){
                corJob5 = CoroutineScope(Dispatchers.Main).launch {
                    loadRandomPoints()
                    if(roulettePoints%2==0){
                        win()
                    }else{
                        Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(requireContext(),"you don't have enough money",Toast.LENGTH_SHORT).show()
            }
        }

        id_roulette_btn_odd.setOnClickListener {
            if(checkMyCash()){
                corJob4 = CoroutineScope(Dispatchers.Main).launch {
                    loadRandomPoints()
                    if(roulettePoints%2==1){
                        win()
                    }else{
                        Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(requireContext(),"you don't have enough money",Toast.LENGTH_SHORT).show()
            }
        }

        id_roulette_btn_red.setOnClickListener {
            if(checkMyCash()){
                corJob2 = CoroutineScope(Dispatchers.Main).launch {
                    loadRandomPoints()
                    if(roulettePoints in listRouletteRed){
                        win()
                    }else{
                        Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(requireContext(),"you don't have enough money",Toast.LENGTH_SHORT).show()
            }
        }

        id_roulette_btn_black.setOnClickListener {
            if(checkMyCash()){
                corJob3 = CoroutineScope(Dispatchers.Main).launch {
                    loadRandomPoints()
                    if(roulettePoints in listRouletteBlack){
                        win()
                    }else{
                        Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(requireContext(),"you don't have enough money",Toast.LENGTH_SHORT).show()
            }
        }


        id_roulette_btn_exact.setOnClickListener {

            MAIN.minusCash(40)
            id_roulette_tv_cash.text = MAIN.getMyCash().toString()

            roulettePoints = listRoulette.shuffled()[1]

            Toast.makeText(requireContext(),"choose any number of points",Toast.LENGTH_SHORT).show()
            for(i in listP){
                i.isEnabled = true
            }

        }




    }

    private fun loadImageCash(){
        Glide.with(requireContext())
            .load(url_image_cash)
            .into(id_roulette_img_cash)
    }

    private fun showPoint(){
        corJob6 = CoroutineScope(Dispatchers.Main).launch {
            id_roulette_points_win.text = roulettePoints.toString()
            if(roulettePoints in listRouletteRed){
                id_roulette_points_win.setBackgroundResource(R.color.color_roulette)
            }else{
                id_roulette_points_win.setBackgroundResource(R.color.black)
            }
            delay(2000)
            id_roulette_points_win.setBackgroundResource(R.color.color_pink_roulette)
            id_roulette_points_win.text = ""
        }
    }

    private fun win(){
        Toast.makeText(requireContext(),"!you guessed right! +60$",Toast.LENGTH_SHORT).show()
        MAIN.addCash(60)
        cashWin+=60
        id_roulette_tv_you_won.text = "you won $cashWin$"
        id_roulette_tv_cash.text = MAIN.getMyCash().toString()
        Toast.makeText(requireContext(),"select any of the buttons again",Toast.LENGTH_SHORT).show()
    }

    private fun checkMyCash(): Boolean {
        return MAIN.getMyCash()>40
    }

    private fun loadRandomPoints(){
        MAIN.minusCash(40)
        id_roulette_tv_cash.text = MAIN.getMyCash().toString()
        showPoint()
        roulettePoints = listRoulette.shuffled()[1]
    }

}