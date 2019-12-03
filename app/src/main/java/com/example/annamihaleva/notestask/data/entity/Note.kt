package com.example.annamihaleva.notestask.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note(
        @ColumnInfo(name = "title") val title: CharSequence,
        @ColumnInfo(name = "body") val body: CharSequence
) : Serializable {

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0
}
