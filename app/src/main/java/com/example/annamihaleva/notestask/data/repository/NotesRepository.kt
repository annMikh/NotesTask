package com.example.annamihaleva.notestask.data.repository

import android.arch.lifecycle.LiveData
import com.example.annamihaleva.notestask.data.db.NoteDataBase
import com.example.annamihaleva.notestask.data.entity.Note
import com.example.annamihaleva.notestask.App
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class NotesRepository {

    private val dataBase: NoteDataBase = App.getInstance().getDatabase()

    fun deleteNote(note: Note) {
        Completable.create {
            dataBase.access().remove(note) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    fun updateNote(note: Note) {
        Completable.create {
            dataBase.access().update(note) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    fun insertNote(note: Note){
        Completable.create {
            dataBase.access().insert(note) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }


    fun getNote(id: Int): LiveData<Note> =
        dataBase.access().getNote(id)


    fun getLiveAllNotes(): LiveData<List<Note>> =
        dataBase.access().getAll()

}