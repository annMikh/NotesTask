package com.example.annamihaleva.notestask.data.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import com.example.annamihaleva.notestask.data.db.NoteDataBase
import com.example.annamihaleva.notestask.data.entity.Note
import javax.inject.Inject
import android.arch.persistence.room.Room


class NotesRepository @Inject constructor(
        private val context: Context
) {

    companion object {
        private const val DATABASE_NAME = "notes_database"
    }

    private val dataBase: NoteDataBase = Room
            .databaseBuilder(context, NoteDataBase::class.java, DATABASE_NAME)
            .build()

    fun deleteNote(note: Note) {
        dataBase.access().remove(note)
    }

    fun updateNote(note: Note) {
        dataBase.access().update(note)
    }

    fun insertNote(note: Note) {
        dataBase.access().insert(note)
    }

    fun getNote(id: Int): LiveData<Note> {
        return dataBase.access().getNote(id)
    }

}