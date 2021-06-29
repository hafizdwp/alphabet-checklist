package com.hafizdwp.alphabet_checklist.data

/**
 * @author hafizdwp
 * 17/05/2021
 **/
//class LocalDataSource(private val database: Database)
class LocalDataSource() {

//    suspend fun initiateTable(list: List<Tes>) {
//        database.tesDao().insert(list)
//    }
//
//    suspend fun getAll(): List<Tes> {
//        return database.tesDao().getAll()
//    }

    companion object {
        private var instance: LocalDataSource? = null

//        @JvmStatic
//        fun getInstance(database: Database): LocalDataSource {
//            return instance ?: synchronized(LocalDataSource::class.java) {
//                instance ?: LocalDataSource(database).also {
//                    instance = it
//                }
//            }
//        }

        fun getInstance() = LocalDataSource()
    }
}