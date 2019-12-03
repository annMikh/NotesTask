package com.example.annamihaleva.notestask.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.di.FragmentModule
import com.example.annamihaleva.notestask.ui.presentation.NewNoteFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.NewNoteView

class NoteFragment: MvpFragment(), NewNoteView {

    companion object {
        const val SCREEN = "NoteFragment"

        fun getInstance(): NoteFragment =
                NoteFragment()
    }

    @InjectPresenter
    lateinit var presenter: NewNoteFragmentPresenter

    @ProvidePresenter
    fun providePresenter() =
            FragmentModule().provideNewNoteFragmentPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_notes_list, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
