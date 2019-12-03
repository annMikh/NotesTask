package com.example.annamihaleva.notestask.ui.presentation

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.annamihaleva.notestask.data.entity.Note

interface NotesListView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun createAdapter()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun addToList(items: List<Any>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun updateNote(note: Note)
}
