package com.example.annamihaleva.notestask.ui.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.view.fragment.ActionsFragment
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter @Inject constructor(
        private val router: Router
): MvpPresenter<MainView>() {

    fun onViewAttach() {
        router.navigateTo(ActionsFragment.SCREEN, null)
    }

}