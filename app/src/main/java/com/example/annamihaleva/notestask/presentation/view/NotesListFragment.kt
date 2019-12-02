package com.example.annamihaleva.notestask.presentation.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.data.Note
import com.example.annamihaleva.notestask.presentation.adapter.NotesAdapter
import com.example.annamihaleva.notestask.presentation.presenter.NotesListPresenter
import kotlinx.android.synthetic.main.fragment_notes_list.*
import javax.inject.Inject

class NotesListFragment : Fragment(), NotesListView {

    interface ListCallback{

        fun onClickDelete()

        fun onClickUpdate()
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

        val callback = object : NotesListFragment.ListCallback{
            override fun onClickDelete() {

            }

            override fun onClickUpdate() {

            }
        }

        notesAdapter = NotesAdapter { viewHolder, _, item -> viewHolder.bind(callback, item) }

        notesList.apply {
            adapter = notesAdapter
            layoutManager = LinearLayoutManager(view.context)
        }
    }

}
