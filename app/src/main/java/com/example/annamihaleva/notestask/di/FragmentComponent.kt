package com.example.annamihaleva.notestask.di

import com.example.annamihaleva.notestask.ui.view.NotesListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FragmentModule::class, MainModule::class])
interface FragmentComponent {

    fun inject(fragment: NotesListFragment)
}
