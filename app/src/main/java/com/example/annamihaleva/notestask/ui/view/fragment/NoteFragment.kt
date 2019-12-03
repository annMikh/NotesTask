package com.example.annamihaleva.notestask.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpFragment
import com.example.annamihaleva.notestask.App
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.ui.presentation.NoteFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.NoteView
import kotlinx.android.synthetic.main.fragment_note.*
import javax.inject.Inject

class NoteFragment: MvpFragment(), NoteView {

    private val note : Note? by lazy {
        arguments?.getSerializable(NOTE_KEY) as? Note
    }

    companion object {
        const val SCREEN = "NoteFragment"
        const val NOTE_KEY = "note_key"

        fun getInstance(data: Note?): NoteFragment {
            val args = Bundle()
            args.putSerializable(NOTE_KEY, data)
            val fragment = NoteFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject lateinit var presenter: NoteFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_note, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.getMainComponent().inject(this)

        note.let {
            noteEdit.setText(note?.body)
            titleEdit.setText(note?.title)
        }

        saveNote.setOnClickListener {
            val newNote = Note(titleEdit.text.toString(), noteEdit.text.toString())
            presenter.onSaveNoteClick(newNote)
        }
    }

}
