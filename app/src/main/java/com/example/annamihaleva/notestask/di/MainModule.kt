package com.example.annamihaleva.notestask.di

import android.content.Context
import com.example.annamihaleva.notestask.data.repository.NotesRepository
import com.example.annamihaleva.notestask.interactor.NotesInteractor
import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.presentation.ActionsFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.MainActivityPresenter
import com.example.annamihaleva.notestask.ui.presentation.NoteFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.NotesListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule(
        val context: Context
) {

    @Provides
    @Singleton
    fun provideMainActivityPresenter(router: Router): MainActivityPresenter =
            MainActivityPresenter(router)

    @Provides
    @Singleton
    fun provideRouter(): Router =
            Router()

    @Provides
    @Singleton
    fun provideNotesInteractor(repository: NotesRepository): NotesInteractor =
            NotesInteractor(repository)

    @Provides
    @Singleton
    fun provideNotesRepository(): NotesRepository =
            NotesRepository()

    @Provides
    @Singleton
    fun provideNotesListPresenter(router: Router, interactor: NotesInteractor): NotesListPresenter =
            NotesListPresenter(router, interactor)

    @Provides
    @Singleton
    fun provideNewNoteFragmentPresenter(router: Router, interactor: NotesInteractor): NoteFragmentPresenter =
            NoteFragmentPresenter(router, interactor)

    @Provides
    @Singleton
    fun provideActionsFragmentPresenter(router: Router): ActionsFragmentPresenter =
            ActionsFragmentPresenter(router)

}
