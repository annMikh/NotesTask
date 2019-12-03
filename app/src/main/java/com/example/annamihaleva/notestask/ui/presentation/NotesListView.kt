package com.example.annamihaleva.notestask.ui.presentation

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface NotesListView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun createAdapter()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun addToList(items: List<Any>)
}
