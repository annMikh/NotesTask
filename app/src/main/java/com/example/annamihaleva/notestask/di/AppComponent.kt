package com.example.annamihaleva.notestask.di

import com.example.annamihaleva.notestask.App
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: App)

}