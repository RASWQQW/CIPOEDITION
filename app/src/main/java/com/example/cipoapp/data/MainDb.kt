package com.example.cipoapp.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = [Stuff::class, Notices::class], version = 3, exportSchema = false)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {

        @Volatile
        private var INSTANCE: MainDb? = null

        fun getDb(context: Context): MainDb {
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDb::class.java,
                    "Cipo.db"

                )   .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}