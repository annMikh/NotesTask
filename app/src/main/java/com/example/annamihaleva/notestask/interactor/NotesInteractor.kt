package com.example.annamihaleva.notestask.interactor

import android.arch.lifecycle.LiveData
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.data.repository.NotesRepository
import javax.inject.Inject

class NotesInteractor @Inject constructor(
        private val repository: NotesRepository
) {

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getLiveAllNotes()
    }

    fun saveNote(note: Note) {
        repository.insertNote(note)
    }

    fun getNote(id: Int): Note? {
        return repository.getNote(id).value
    }

    fun deleteNote(note: Note) {
        repository.deleteNote(note)
    }

    fun updateNote(note: Note) {
        repository.updateNote(note)
    }
}