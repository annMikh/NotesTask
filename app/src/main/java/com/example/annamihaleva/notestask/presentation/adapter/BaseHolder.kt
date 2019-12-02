package com.example.annamihaleva.notestask.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.annamihaleva.notestask.data.Note
import com.example.annamihaleva.notestask.presentation.view.NotesListFragment

abstract class BaseHolder(val view: View): RecyclerView.ViewHolder(view) {

    abstract fun bind(callback: NotesListFragment.ListCallback, note: Note)

}
