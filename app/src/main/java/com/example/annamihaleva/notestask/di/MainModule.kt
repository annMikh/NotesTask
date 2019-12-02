package com.example.annamihaleva.notestask.di

import com.arellomobile.mvp.MvpPresenter
import com.example.annamihaleva.notestask.presentation.presenter.MainActivityPresenter
import com.example.annamihaleva.notestask.presentation.view.MainView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideMainActivityPresenter(): MvpPresenter<MainView> =
            MainActivityPresenter()

}
