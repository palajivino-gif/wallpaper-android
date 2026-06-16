package com.demo.wallpaper

import android.app.Application
import com.google.android.gms.ads.MobileAds

class WalloraApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Thread {
            MobileAds.initialize(this) {}
        }.start()
    }
}
