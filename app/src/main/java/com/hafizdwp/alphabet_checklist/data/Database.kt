package com.hafizdwp.alphabet_checklist.data

//@androidx.room.Database(entities = [Tes::class], version = 1)
//abstract class Database : RoomDatabase() {
//
//    abstract fun tesDao(): TesDao
//
//    companion object {
//        @Volatile
//        private var instance: Database? = null
//
//        fun getInstance(context: Context): Database {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return instance ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        Database::class.java,
//                        "database"
//                )
//                        // Wipes and rebuilds instead of migrating if no Migration object.
//                        // Migration is not part of this codelab.
//                        .fallbackToDestructiveMigration()
//                        .allowMainThreadQueries()
//                        .build()
//
//                this.instance = instance
//
//                // return instance
//                instance
//            }
//        }
//    }
//}