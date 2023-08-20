package com.shruti.crudlivedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LiveDataDao {
    @Insert
    suspend fun insertNotes(liveDataEntity: LiveDataEntity)
    @Query("SELECT * FROM LiveDataEntity")
    fun getNotes(): LiveData<List<LiveDataEntity>>
}