package com.example.annamihaleva.notestask.ui.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.interactor.NotesInteractor
import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.view.fragment.NoteFragment
import javax.inject.Inject

@InjectViewState
class NotesListPresenter @Inject constructor(
        private val router: Router,
        private val interactor: NotesInteractor
): MvpPresenter<NotesListView>() {

    private lateinit var allNotes: List<Note>

    fun onInit() {
        allNotes = interactor.getAllNotes().value ?: arrayListOf()

        viewState.createAdapter()
        viewState.addToList(allNotes)
    }

    fun onEditNoteClick(data: Any) {
        router.navigateTo(NoteFragment.SCREEN, data)
    }

}
