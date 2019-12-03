package com.example.annamihaleva.notestask.ui.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpFragment
import com.example.annamihaleva.notestask.App
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.ui.adapter.NotesAdapter
import com.example.annamihaleva.notestask.ui.presentation.NotesListPresenter
import com.example.annamihaleva.notestask.ui.presentation.NotesListView
import kotlinx.android.synthetic.main.fragment_notes_list.*
import javax.inject.Inject


class NotesListFragment : MvpFragment(), NotesListView {

    companion object {
        const val SCREEN = "NotesListFragment"

        fun getInstance(): NotesListFragment =
                NotesListFragment()
    }

    interface ListCallback{

        fun onClickDelete(note: Note)

        fun onClickUpdate(note: Note)
    }

    @Inject
    lateinit var presenter: NotesListPresenter

    private lateinit var notesAdapter: NotesAdapter<Note>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notes_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.getMainComponent().inject(this)
        presenter.onInit()
    }


    override fun createAdapter() {
        val callback = object : ListCallback {
            override fun onClickDelete(note: Note) {
                notesAdapter.remove(note)
            }

            override fun onClickUpdate(note: Note) {
                presenter.onEditNoteClick(note)
            }
        }

        notesAdapter = NotesAdapter { viewHolder, _, item -> viewHolder.bind(callback, item) }

        notesList.apply {
            adapter = notesAdapter
            layoutManager = LinearLayoutManager(view?.context)
        }
    }

    override fun addToList(items: List<Any>) {
        notesAdapter.addAll(items.filterIsInstance<Note>())
    }

    override fun updateNote(note: Note) {
        notesAdapter.update(note)
    }

}
