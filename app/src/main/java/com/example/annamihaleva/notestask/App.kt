package com.example.annamihaleva.notestask

import android.app.Application
import com.example.annamihaleva.notestask.di.*

class App : Application() {

    private lateinit var mainComponent: MainComponent
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent
                .builder()
                .mainModule(MainModule())
                .build()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
    }

    fun getMainActivityComponent(): MainComponent = mainComponent

}