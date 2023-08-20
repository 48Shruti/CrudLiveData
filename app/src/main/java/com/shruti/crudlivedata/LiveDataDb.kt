package com.shruti.crudlivedata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(version = 1, entities = [LiveDataEntity::class])
    abstract class LiveDataDb : RoomDatabase() {
        abstract fun liveDataDao(): LiveDataDao

        companion object {
           var liveDataDb: LiveDataDb? = null
            fun getDatabase(context: Context): LiveDataDb {
                if (liveDataDb == null) {
                    liveDataDb = Room.databaseBuilder(
                        context,
                        LiveDataDb::class.java,
                        context.resources.getString(R.string.app_name)
                    ).build()
                }
                return liveDataDb!!
            }
        }
    }




