package com.example.annamihaleva.notestask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.annamihaleva.notestask.R


class NotesAdapter <T>(bind : (holder: BaseHolder, pos: Int, item: T) -> Unit): BaseAdapter<T>(bind) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseHolder {
        val view = LayoutInflater.from(p0.context)
                .inflate(R.layout.list_note_item, p0, false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int =
            getSize()

}
