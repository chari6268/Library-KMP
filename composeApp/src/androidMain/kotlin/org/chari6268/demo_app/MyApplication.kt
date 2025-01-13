package org.chari6268.demo_app

import android.app.Application
import org.chari6268.demo_app.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin {
            androidContext(this@MyApplication)
        }
    }
}