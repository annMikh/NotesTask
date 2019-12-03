package com.example.annamihaleva.notestask.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.annamihaleva.notestask.data.dao.Storage
import com.example.annamihaleva.notestask.data.entity.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun access(): Storage

}