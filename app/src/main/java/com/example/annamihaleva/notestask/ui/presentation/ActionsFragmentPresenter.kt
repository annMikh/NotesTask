package com.example.annamihaleva.notestask.ui.presentation

import com.arellomobile.mvp.MvpPresenter
import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.view.NoteFragment
import com.example.annamihaleva.notestask.ui.view.NotesListFragment
import javax.inject.Inject

class ActionsFragmentPresenter @Inject constructor(
        private val router: Router
): MvpPresenter<ActionsView>() {

    fun onAddNewNote() {
        router.navigateTo(NoteFragment.SCREEN)
    }

    fun onViewAllNotes() {
        router.navigateTo(NotesListFragment.SCREEN)
    }
}
