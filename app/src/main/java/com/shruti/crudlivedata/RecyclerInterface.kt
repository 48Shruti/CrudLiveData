package com.shruti.crudlivedata

import android.icu.text.Transliterator.Position

interface RecyclerInterface {
    fun deleteNotes(entity: NotesEntity,position : Int)
    fun updateNotes(entity: NotesEntity,position : Int)
}