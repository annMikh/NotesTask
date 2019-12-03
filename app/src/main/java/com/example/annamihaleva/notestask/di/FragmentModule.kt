package com.example.annamihaleva.notestask.di

import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.presentation.ActionsFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.NoteFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.NotesListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FragmentModule {

    @Provides
    @Singleton
    fun provideNotesListPresenter(router: Router): NotesListPresenter =
            NotesListPresenter(router)

    @Provides
    @Singleton
    fun provideNewNoteFragmentPresenter(router: Router): NoteFragmentPresenter =
            NoteFragmentPresenter(router)

    @Provides
    @Singleton
    fun provideActionsFragmentPresenter(router: Router): ActionsFragmentPresenter =
            ActionsFragmentPresenter(router)

}
