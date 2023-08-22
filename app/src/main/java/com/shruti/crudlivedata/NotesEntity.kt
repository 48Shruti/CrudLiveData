package com.shruti.crudlivedata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Calendar

@Entity
data class NotesEntity(
@PrimaryKey
var id : Int = 0,
@ColumnInfo
var title : String ?= null,
@ColumnInfo
var description : String ?= null,
@ColumnInfo
var time : String ?= SimpleDateFormat("dd/mm/yyyy").format(Calendar.getInstance().time))


