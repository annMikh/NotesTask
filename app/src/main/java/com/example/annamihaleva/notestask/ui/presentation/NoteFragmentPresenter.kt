package com.example.annamihaleva.notestask.ui.presentation

import com.arellomobile.mvp.MvpPresenter
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.interactor.NotesInteractor
import com.example.annamihaleva.notestask.router.Router
import javax.inject.Inject

class NoteFragmentPresenter @Inject constructor(
        private val router: Router,
        private val interactor: NotesInteractor
): MvpPresenter<NoteView>() {

    fun onSaveNoteClick(newNote: Note) {
        interactor.saveNote(newNote)
        router.back()
    }

}
