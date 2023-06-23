package com.example.mycasino4

import android.app.Application
import com.onesignal.OneSignal

class OneSignalApplication:Application() {

    val ONESIGNAL_APP_ID = "fa35704b-b16a-45ad-9cb9-44c294582444"

    override fun onCreate() {
        super.onCreate()

        //OneSignal.initWithContext(this)
        //OneSignal.setAppId(ONESIGNAL_APP_ID)

    }

}