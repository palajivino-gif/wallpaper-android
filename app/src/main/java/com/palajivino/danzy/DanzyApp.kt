package com.palajivino.danzy

import android.app.Application
import com.google.android.gms.ads.MobileAds

class DanzyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Thread {
            MobileAds.initialize(this) {}
        }.start()
    }
}
