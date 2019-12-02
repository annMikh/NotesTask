package com.example.annamihaleva.notestask.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.annamihaleva.notestask.App
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.presentation.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        addNewNote.setOnClickListener {
            presenter.onAddNewNote()
        }

        viewAllNotes.setOnClickListener {
            presenter.onViewAllNotes()
        }
    }

    private fun init() {
        (application as App)
                .getMainActivityComponent()
                .inject(this)
    }

}
