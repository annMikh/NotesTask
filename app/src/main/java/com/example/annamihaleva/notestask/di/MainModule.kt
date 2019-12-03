package com.example.annamihaleva.notestask.di

import android.app.FragmentManager
import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.presentation.MainActivityPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule(val fragmentManager: FragmentManager) {

    @Provides
    @Singleton
    fun provideMainActivityPresenter(router: Router): MainActivityPresenter =
            MainActivityPresenter(router)

    @Provides
    @Singleton
    fun provideRouter(): Router =
            Router(fragmentManager)

}
