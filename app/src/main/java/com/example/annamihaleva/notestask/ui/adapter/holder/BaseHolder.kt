package com.example.annamihaleva.notestask.ui.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.ui.view.fragment.NotesListFragment

abstract class BaseHolder(val view: View): RecyclerView.ViewHolder(view) {

    abstract fun bind(callback: NotesListFragment.ListCallback?, note: Note)

}
