package com.shruti.crudlivedata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application){
     var notesList : LiveData<List<NotesEntity>>
     var notesDao : NotesDao
     init {
         notesDao= NotesDb.getDatabase(application).notesDao()
         notesList = notesDao.getNotes()
     }
    fun insertNotes(notesEntity: NotesEntity){
        viewModelScope.launch{
            notesDao.insertNotes(notesEntity)
        }
    }
    fun deleteNotes(notesEntity: NotesEntity){
        viewModelScope.launch{
            notesDao.deleteNotes(notesEntity)
        }
    }
    fun updateNotes(notesEntity: NotesEntity){
        viewModelScope.launch{
            notesDao.updateNotes(notesEntity)
        }}
}