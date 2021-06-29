package com.hafizdwp.alphabet_checklist.data.local.table

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author hafizdwp
 * 29/06/2021
 **/

@Entity(tableName = Hero.TABLE_NAME)
data class Hero(
    var name: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    companion object {
        const val TABLE_NAME = "table_heroes"
    }
}