package com.example.annamihaleva.notestask.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.presentation.NoteFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.NoteView
import kotlinx.android.synthetic.main.fragment_note.*

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

    @InjectPresenter
    lateinit var presenter: NoteFragmentPresenter

    @ProvidePresenter
    fun providePresenter() =
            NoteFragmentPresenter(Router(fragmentManager))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_note, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
