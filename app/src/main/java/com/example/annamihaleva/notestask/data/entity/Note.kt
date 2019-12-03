package com.example.annamihaleva.notestask.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Note")
data class Note(
        @ColumnInfo(name = "title") var title: String = "",
        @ColumnInfo(name = "body") var body: String = "",
        @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Int = 0
) : Serializable
