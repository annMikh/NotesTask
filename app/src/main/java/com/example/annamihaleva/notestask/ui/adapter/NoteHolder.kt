package com.example.annamihaleva.notestask.ui.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.data.Note
import com.example.annamihaleva.notestask.ui.view.NotesListFragment

class NoteHolder(v: View): BaseHolder(v) {

    private var noteText: TextView = v.findViewById(R.id.noteText)
    private var deleteNote: Button = v.findViewById(R.id.deleteNote)
    private var updateNote: Button = v.findViewById(R.id.updateNote)

    override fun bind(callback: NotesListFragment.ListCallback?, note: Note) {
        noteText.text = note.note.toString()

        deleteNote.setOnClickListener {
            callback?.onClickDelete(note)
        }

        updateNote.setOnClickListener {
            callback?.onClickUpdate(note)
        }
    }

}
