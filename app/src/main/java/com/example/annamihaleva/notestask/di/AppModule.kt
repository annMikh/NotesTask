package com.example.annamihaleva.notestask.di

import com.example.annamihaleva.notestask.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): App {
        return app
    }

}