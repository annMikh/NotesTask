package com.example.annamihaleva.notestask

import android.app.Application
import android.arch.persistence.room.Room
import com.example.annamihaleva.notestask.data.db.NoteDataBase
import com.example.annamihaleva.notestask.di.DaggerMainComponent
import com.example.annamihaleva.notestask.di.MainComponent
import com.example.annamihaleva.notestask.di.MainModule
import android.app.Activity

class App : Application() {

    private var database: NoteDataBase? = null

    companion object {
        private var instance: App? = null
        private const val DATABASE_NAME = "notes_database"

        private lateinit var mainComponent : MainComponent

        fun getMainComponent(): MainComponent =
                mainComponent

        fun getInstance(): App {
            return instance as App
        }

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room
                .databaseBuilder(this, NoteDataBase::class.java, DATABASE_NAME)
                .build()

        mainComponent = DaggerMainComponent
                .builder()
                .mainModule(MainModule(applicationContext))
                .build()
    }

    private lateinit var currentActivity: Activity

    fun getCurrentActivity(): Activity? {
        return currentActivity
    }

    fun setCurrentActivity(activity: Activity) {
        this.currentActivity = activity
    }

    fun getDatabase(): NoteDataBase {
        return database as NoteDataBase
    }

}