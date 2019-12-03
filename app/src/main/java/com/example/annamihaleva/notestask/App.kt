package com.example.annamihaleva.notestask

import android.app.Application
import com.example.annamihaleva.notestask.di.*

class App : Application() {

    private lateinit var fragmentComponent: FragmentComponent


    override fun onCreate() {
        super.onCreate()

        fragmentComponent = DaggerFragmentComponent
                .builder()
                .fragmentModule(FragmentModule())
                .build()
    }

    fun getFragmentComponent(): FragmentComponent = fragmentComponent

}