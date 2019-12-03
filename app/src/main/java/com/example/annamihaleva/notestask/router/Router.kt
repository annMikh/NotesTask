package com.example.annamihaleva.notestask.router

import android.app.FragmentManager
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.ui.view.ActionsFragment
import com.example.annamihaleva.notestask.ui.view.NoteFragment
import com.example.annamihaleva.notestask.ui.view.NotesListFragment
import javax.inject.Inject

class Router @Inject constructor(private val fm: FragmentManager) {

    fun navigateTo(name: String){
        val transaction = fm
                .beginTransaction()
                .addToBackStack(name)

        when(name) {
            NotesListFragment.SCREEN ->
                transaction.add(R.id.container, NotesListFragment.getInstance())
            ActionsFragment.SCREEN ->
                transaction.add(R.id.container, ActionsFragment.getInstance())
            NoteFragment.SCREEN ->
                transaction.add(R.id.container, NoteFragment.getInstance())
        }

        transaction.commit()
    }

}