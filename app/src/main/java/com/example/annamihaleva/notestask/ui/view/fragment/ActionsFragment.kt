package com.example.annamihaleva.notestask.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpFragment
import com.example.annamihaleva.notestask.App
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.ui.presentation.ActionsFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.ActionsView
import kotlinx.android.synthetic.main.fragment_actions.*
import javax.inject.Inject

class ActionsFragment: MvpFragment(), ActionsView {

    @Inject
    lateinit var presenter: ActionsFragmentPresenter

    companion object {
        const val SCREEN = "ActionsFragment"

        fun getInstance(): ActionsFragment =
                ActionsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_actions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.getMainComponent().inject(this)

        addNewNote.setOnClickListener {
            presenter.onAddNewNote()
        }

        viewAllNotes.setOnClickListener {
            presenter.onViewAllNotes()
        }
    }
}
