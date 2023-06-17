package com.example.mycasino4.constant

import com.example.mycasino4.view.activity.MainActivity

lateinit var MAIN:MainActivity

const val GAME = "GAME"
const val BLACKJACK = "BLACKJACK"
const val JACKPOT = "JACKPOT"
const val ROULETTE = "ROULETTE"

const val APP_PREFERENCES = "APP_PREFERENCES"
const val LAST_DAY = "LAST_DAY"
const val MY_CASH = "MY_CASH"

const val ID = "ID"

//menu//////////////////////////////////////////////////////////////////////////////////////////////
const val url_image_menu_blackjack = "http://37.27.9.28/11/blackjack_menu-YZNZ3Tpju-transformed.png"
const val url_image_menu_roulette = "http://37.27.9.28/11/roulette_menu-transformed.png"
const val url_image_menu_jackpot = "http://37.27.9.28/11/jackpot_menu.png"
const val url_image_cash = "http://37.27.9.28/11/casino3cash-transformed.png"
////////////////////////////////////////////////////////////////////////////////////////////////////

//loading///////////////////////////////////////////////////////////////////////////////////////////
const val url_image_loaing_blackjack = "http://37.27.9.28/11/blackjack-transformed.png"
const val url_image_loading_roulette = "http://37.27.9.28/11/roulette-transformed.png"
const val url_image_loading_jackpot = "http://37.27.9.28/11/jackpot-transformed.png"
////////////////////////////////////////////////////////////////////////////////////////////////////

//splash////////////////////////////////////////////////////////////////////////////////////////////
const val url_image_splash = "http://37.27.9.28/11/casino4oboi.png"
////////////////////////////////////////////////////////////////////////////////////////////////////


//jackpot///////////////////////////////////////////////////////////////////////////////////////////
const val url_image_jackpot = "http://37.27.9.28/11/title_jackpot-transformed.png"
////////////////////////////////////////////////////////////////////////////////////////////////////

var listNumberForJackpot = listOf(1,3,5,7,9)

//roulette//////////////////////////////////////////////////////////////////////////////////////////
var listRoulette = listOf(1,2,3,4,5,6,7,8,9,
                          10,11,12,13,14,15,16,17,18,19,20,
                          21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36)

var listRouletteRed = listOf(1,3,5,8,10,12,13,15,17,20,22,24,25,27,29,32,34,36)
var listRouletteBlack = listOf(2,4,6,7,9,11,14,16,18,19,21,23,26,28,30,31,33,35)
////////////////////////////////////////////////////////////////////////////////////////////////////

//blackjack/////////////////////////////////////////////////////////////////////////////////////////
const val url_image_blackjack = "http://37.27.9.28/11/blackjack_title.png"

var listAllCard = listOf("6chervi.png","7chervi.png","8chervi.png",
    "9chervi.jpg" ,"10chervi.png","waletchervi.png",
    "damachervi.png","kingchervi.png","tuzchervi.png",
    "6bubi.jpg","7bubi.png","8bubi.png",
    "9bubi.jpg","10bubi.png","waletbubi.jpg",
    "damabubi.png","kingbubi.png","tuzbubi.png",
    "6piki.png","7piki.jpg","8piki.png",
    "9piki.png","10piki.png","waletpiki.png",
    "damapiki.jpg","kingpiki.png","tuzpiki.jpg",
    "6kresti.jpg","7kresti.jpg","8kresti.png",
    "9kresti.png","10kresti.png","waletkresti.png",
    "damakresti.png","kingkresti.png","tuzkresti.png")

const val url_obratnaya_card = "http://37.27.9.28/11/obratnaya_storona.png"

var mapAllCard = mapOf("6chervi.png" to 6,"7chervi.png" to 7,"8chervi.png" to 8,
    "9chervi.jpg" to 9,"10chervi.png" to 10 ,"waletchervi.png" to 1,
    "damachervi.png" to 2,"kingchervi.png" to 3,"tuzchervi.png" to 4,
    "6bubi.jpg" to 6,"7bubi.png" to 7,"8bubi.png" to 8,
    "9bubi.jpg" to 9,"10bubi.png" to 10,"waletbubi.jpg" to 1,
    "damabubi.png" to 2,"kingbubi.png" to 3,"tuzbubi.png" to 4,
    "6piki.png" to 6,"7piki.jpg" to 7,"8piki.png" to 8,
    "9piki.png" to 9,"10piki.png" to 10 ,"waletpiki.png" to 1,
    "damapiki.jpg" to 2,"kingpiki.png" to 3,"tuzpiki.jpg" to 4,
    "6kresti.jpg" to 6,"7kresti.jpg" to 7,"8kresti.png" to 8,
    "9kresti.png" to 9,"10kresti.png" to 10,"waletkresti.png" to 1,
    "damakresti.png" to 2,"kingkresti.png" to 3,"tuzkresti.png" to 4)


