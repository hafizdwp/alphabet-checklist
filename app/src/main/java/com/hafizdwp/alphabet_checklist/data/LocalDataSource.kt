package com.hafizdwp.alphabet_checklist.data

import com.hafizdwp.alphabet_checklist.data.local.table.Hero

/**
 * @author hafizdwp
 * 17/05/2021
 **/
class LocalDataSource(private val database: Database) {

    suspend fun addHero(hero: Hero) {
        database.heroDao().insert(hero)
    }

    suspend fun getHeroes(): List<Hero> {
        return database.heroDao().getAll()
    }

//    suspend fun initiateTable(list: List<Tes>) {
//        database.tesDao().insert(list)
//    }
//
//    suspend fun getAll(): List<Tes> {
//        return database.tesDao().getAll()
//    }

    companion object {
        private var instance: LocalDataSource? = null

        @JvmStatic
        fun getInstance(database: Database): LocalDataSource {
            return instance ?: synchronized(LocalDataSource::class.java) {
                instance ?: LocalDataSource(database).also {
                    instance = it
                }
            }
        }
    }
}