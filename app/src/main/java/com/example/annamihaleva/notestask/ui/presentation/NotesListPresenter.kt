package com.example.annamihaleva.notestask.ui.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.annamihaleva.notestask.data.Note

@InjectViewState
class NotesListPresenter: MvpPresenter<NotesListView>(){

    fun onInit() {
        val mock = mutableListOf(Note("this"), Note("example"), Note("cat"), Note("note note"), Note("android"))
        viewState.createAdapter()
        viewState.addToList(mock)
    }

}
