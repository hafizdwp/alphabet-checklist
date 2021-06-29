package com.hafizdwp.alphabet_checklist.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hafizdwp.alphabet_checklist.data.local.dao.HeroDao
import com.hafizdwp.alphabet_checklist.data.local.table.Hero

@androidx.room.Database(
        version = Database.DB_VERSION,
        entities = [
            Hero::class
        ],
        exportSchema = true
)
abstract class Database : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    companion object {

        const val DB_VERSION = 1
        private const val DB_NAME = "heroes.db"

        @Volatile
        private var instance: Database? = null

        fun getInstance(context: Context): Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        Database::class.java,
                        DB_NAME
                )
                        // Wipes and rebuilds instead of migrating if no Migration object.
                        // Migration is not part of this codelab.
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

                this.instance = instance

                // return instance
                instance
            }
        }
    }
}