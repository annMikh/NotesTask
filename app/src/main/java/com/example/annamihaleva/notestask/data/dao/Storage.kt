package com.example.annamihaleva.notestask.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.annamihaleva.notestask.data.entity.Note

@Dao
interface Storage {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun remove(note: Note)

    @Query("select * from Note")
    fun getAll(): LiveData<List<Note>>

    @Query("select * from Note where id=:noteId")
    fun getNote(noteId: Int): LiveData<Note>

}
