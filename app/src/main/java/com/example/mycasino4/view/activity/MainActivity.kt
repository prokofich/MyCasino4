package com.example.mycasino4.view.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mycasino4.R
import com.example.mycasino4.constant.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MAIN = this
        navController = Navigation.findNavController(this,R.id.id_nav_host)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

    }

    fun getLastDay():String{
        val preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getString(LAST_DAY,"")
        return preferences ?: ""
    }

    fun setCurrentDay(day:String){
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        preferences.edit()
            .putString(LAST_DAY,day)
            .apply()
    }

    fun getMyCash(): Int {
        return getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE).getInt(MY_CASH, 0)
    }

    fun addCash(cash:Int){
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE).getInt(MY_CASH,0) + cash
        val pref = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        pref.edit()
            .putInt(MY_CASH,preferences)
            .apply()
    }

    fun minusCash(cash: Int){
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE).getInt(MY_CASH,0) - cash
        val pref = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        pref.edit()
            .putInt(MY_CASH,preferences)
            .apply()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if(contextGame == "MENU"){
            finishAffinity()
        }

    }




}