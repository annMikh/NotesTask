package com.example.annamihaleva.notestask.ui.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.view.NoteFragment
import javax.inject.Inject

@InjectViewState
class NotesListPresenter @Inject constructor(
        private val router: Router
): MvpPresenter<NotesListView>(){

    fun onInit() {
        val mock = mutableListOf(Note("title", "this"), Note("title", "example"),
                Note("title", "cat"), Note("title", "body body"), Note("title", "android"))
        viewState.createAdapter()
        viewState.addToList(mock)
    }

    fun onEditNoteClick(data: Any) {
        router.navigateTo(NoteFragment.SCREEN, data)
    }

}
