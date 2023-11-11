package com.kredit.onlain.merca

import android.app.Application
import com.kredit.onlain.merca.data.APP_METRICA
import com.kredit.onlain.merca.data.MY_TRACKER
import com.kredit.onlain.merca.data.USER_X
import com.my.tracker.MyTracker
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp
import pro.userx.UserX

@HiltAndroidApp
class Ml7App: Application() {
    override fun onCreate() {
        super.onCreate()

        val config = YandexMetricaConfig.newConfigBuilder(APP_METRICA).build()


        MyTracker.initTracker(MY_TRACKER, this)
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        UserX.init(USER_X)
    }
}