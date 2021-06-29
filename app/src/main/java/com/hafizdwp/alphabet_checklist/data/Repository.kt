package com.hafizdwp.alphabet_checklist.data

import com.hafizdwp.alphabet_checklist.data.local.table.Hero

/**
 * @author hafizdwp
 * 17/05/2021
 **/
class Repository(private val remoteDataSource: RemoteDataSource,
                 private val localDataSource: LocalDataSource) {

    suspend fun addHero(hero: Hero) {
        localDataSource.addHero(hero)
    }

    suspend fun getHeroes(): List<Hero> {
        return localDataSource.getHeroes()
    }

    companion object {
        private var instance: Repository? = null

        @JvmStatic
        fun getInstance(rds: RemoteDataSource, lds: LocalDataSource): Repository {
            return instance ?: synchronized(Repository::class.java) {
                instance ?: Repository(rds, lds).also {
                    instance = it
                }
            }
        }
    }
}