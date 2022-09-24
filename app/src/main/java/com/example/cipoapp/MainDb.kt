package com.example.cipoapp
import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = [Stuff::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        fun getDb(context: Context): MainDb {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java, "Cipo.db"

            ).fallbackToDestructiveMigration()
             .build()
        }
    }
}