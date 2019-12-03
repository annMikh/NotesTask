package com.example.annamihaleva.notestask.router

import android.app.Activity
import android.app.FragmentManager
import com.example.annamihaleva.notestask.App
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.ui.view.fragment.ActionsFragment
import com.example.annamihaleva.notestask.ui.view.fragment.NoteFragment
import com.example.annamihaleva.notestask.ui.view.fragment.NotesListFragment

class Router {

    private val containerId : Int = R.id.container

    private val fragmantManager: FragmentManager by lazy {
        (App.getInstance().getCurrentActivity() as Activity).fragmentManager
    }

    fun navigateTo(name: String, data: Any?) {

        val transaction = fragmantManager
                .beginTransaction()
                .addToBackStack(name)

        when(name) {
            NotesListFragment.SCREEN ->
                transaction.replace(containerId, NotesListFragment.getInstance())
            ActionsFragment.SCREEN ->
                transaction.replace(containerId, ActionsFragment.getInstance())
            NoteFragment.SCREEN ->
                transaction.replace(containerId, NoteFragment.getInstance(data as? Note))
        }

        transaction.commit()
    }

    fun back(){
        fragmantManager.popBackStack()
    }

}