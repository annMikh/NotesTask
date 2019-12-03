package com.example.annamihaleva.notestask.di

import com.example.annamihaleva.notestask.ui.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface MainComponent {

    fun inject(activity: MainActivity)

}
