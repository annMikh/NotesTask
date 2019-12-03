package com.example.annamihaleva.notestask.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.router.Router
import com.example.annamihaleva.notestask.ui.presentation.ActionsFragmentPresenter
import com.example.annamihaleva.notestask.ui.presentation.ActionsView
import kotlinx.android.synthetic.main.fragment_actions.*

class ActionsFragment: MvpFragment(), ActionsView {

    @InjectPresenter
    lateinit var presenter: ActionsFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): ActionsFragmentPresenter {
        return ActionsFragmentPresenter(Router(fragmentManager))
    }

    companion object {
        const val SCREEN = "ActionsFragment"

        fun getInstance(): ActionsFragment =
                ActionsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_actions, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNewNote.setOnClickListener {
            presenter.onAddNewNote()
        }

        viewAllNotes.setOnClickListener {
            presenter.onViewAllNotes()
        }
    }
}
