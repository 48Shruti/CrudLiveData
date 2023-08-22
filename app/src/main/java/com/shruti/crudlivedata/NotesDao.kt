package com.shruti.crudlivedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {
    @Insert
    suspend fun insertNotes(notesEntity: NotesEntity)
    @Query("SELECT * FROM NotesEntity")
    fun getNotes(): LiveData<List<NotesEntity>>

    @Delete
    suspend fun deleteNotes(notesEntity: NotesEntity)

    @Update
    suspend fun updateNotes(notesEntity: NotesEntity)
}