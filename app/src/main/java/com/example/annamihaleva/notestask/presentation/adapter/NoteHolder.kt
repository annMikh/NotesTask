package com.example.annamihaleva.notestask.presentation.adapter

import android.view.View
import android.widget.TextView
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.data.Note
import com.example.annamihaleva.notestask.presentation.view.NotesListFragment

class NoteHolder(private val v: View): BaseHolder(v) {

    var noteText: TextView = v.findViewById(R.id.noteText)

    override fun bind(callback: NotesListFragment.ListCallback, note: Note) {
        noteText.text = note.note
    }

}
