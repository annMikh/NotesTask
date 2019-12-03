package com.example.annamihaleva.notestask.ui.view

import android.os.Bundle
import com.arellomobile.mvp.MvpActivity
import com.example.annamihaleva.notestask.R
import com.example.annamihaleva.notestask.di.DaggerMainComponent
import com.example.annamihaleva.notestask.di.MainModule
import com.example.annamihaleva.notestask.ui.presentation.MainActivityPresenter
import com.example.annamihaleva.notestask.ui.presentation.MainView
import javax.inject.Inject


class MainActivity : MvpActivity(), MainView {

    @Inject
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        presenter.onViewAttach()
    }

    private fun init() {
        DaggerMainComponent
                .builder()
                .mainModule(MainModule(fragmentManager))
                .build()
                .inject(this)
    }

}
