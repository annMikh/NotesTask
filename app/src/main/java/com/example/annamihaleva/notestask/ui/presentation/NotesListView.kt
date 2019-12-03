package com.example.annamihaleva.notestask.ui.presentation

import android.arch.lifecycle.LiveData
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.annamihaleva.notestask.data.entity.Note

interface NotesListView: MvpView {

    fun createAdapter()

    fun addToList(items: List<Any>)

    fun updateNote(note: Note)
}
