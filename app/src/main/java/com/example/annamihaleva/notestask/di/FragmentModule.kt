package com.example.annamihaleva.notestask.di

import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.presentation.ActionsFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.NewNoteFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.NotesListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FragmentModule {

    @Provides
    @Singleton
    fun provideNotesListPresenter(): NotesListPresenter =
            NotesListPresenter()

    @Provides
    @Singleton
    fun provideNewNoteFragmentPresenter(): NewNoteFragmentPresenter =
            NewNoteFragmentPresenter()

    @Provides
    @Singleton
    fun provideActionsFragmentPresenter(router: Router): ActionsFragmentPresenter =
            ActionsFragmentPresenter(router)

}
