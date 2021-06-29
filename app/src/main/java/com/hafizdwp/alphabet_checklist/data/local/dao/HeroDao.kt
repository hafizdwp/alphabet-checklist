package com.hafizdwp.alphabet_checklist.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.hafizdwp.alphabet_checklist.base.BaseDao
import com.hafizdwp.alphabet_checklist.data.local.table.Hero

/**
 * @author hafizdwp
 * 29/06/2021
 **/

@Dao
abstract class HeroDao : BaseDao<Hero> {

    @Query("SELECT * FROM table_heroes")
    abstract suspend fun getAll(): List<Hero>

    @Query("DELETE FROM table_heroes")
    abstract suspend fun nuke()
}