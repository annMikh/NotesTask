package com.example.annamihaleva.notestask.di

import com.example.annamihaleva.notestask.ui.view.fragment.ActionsFragment
import com.example.annamihaleva.notestask.ui.view.activity.MainActivity
import com.example.annamihaleva.notestask.ui.view.fragment.NoteFragment
import com.example.annamihaleva.notestask.ui.view.fragment.NotesListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface MainComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: ActionsFragment)

    fun inject(fragment: NoteFragment)

    fun inject(fragment: NotesListFragment)

}
