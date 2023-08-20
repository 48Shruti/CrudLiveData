package com.shruti.crudlivedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application){
     var notesList : LiveData<List<LiveDataEntity>>
     var liveDataDao : LiveDataDao
     init {
         liveDataDao= LiveDataDb.getDatabase(application).liveDataDao()
         notesList = liveDataDao.getNotes()
     }
    fun insertNotes(liveDataEntity: LiveDataEntity){
        viewModelScope.launch{
            liveDataDao.insertNotes(liveDataEntity)
        }
    }
}