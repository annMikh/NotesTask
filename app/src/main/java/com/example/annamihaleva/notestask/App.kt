package com.example.annamihaleva.notestask

import android.app.Application
import com.example.annamihaleva.notestask.di.*

class App : Application() {

    private lateinit var appComponent: AppComponent
    private lateinit var fragmentComponent: FragmentComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()

        fragmentComponent = DaggerFragmentComponent
                .builder()
                .fragmentModule(FragmentModule())
                .build()

        appComponent.inject(this)
    }

    fun getFragmentComponent(): FragmentComponent = fragmentComponent

}