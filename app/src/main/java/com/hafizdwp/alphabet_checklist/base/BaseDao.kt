package com.hafizdwp.alphabet_checklist.base

import androidx.room.*


/**
 * Created by mochadwi on 8/3/18.
 */
@Dao
interface BaseDao<TABLE> {
    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     * @return The SQLite row id
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(obj: TABLE): Long

    /**
     * Insert an array of objects in the database.
     *
     * @param objList the objects to be inserted.
     * @return The SQLite row ids
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(objList: List<TABLE>): List<Long>

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    suspend fun update(obj: TABLE): Int

    /**
     * Update an array of objects from the database.
     *
     * @param objList the object to be updated
     */
    @Update
    suspend fun update(objList: List<TABLE>): Int

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    @Delete
    suspend fun delete(obj: TABLE)

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    @Delete
    suspend fun delete(obj: List<TABLE>)

//    /**
//     * Upsert for object
//     *
//     * @param obj
//     */
//    @Transaction
//    fun upsert(obj: T): Int {
//        val id = insert(obj)
//        if (id == -1L) {
//            return update(obj)
//        }
//
//        return id.toInt()
//    }

    /**
     * Upsert for object list
     *
     * @param objList
     */
//    @Transaction
//    fun upsert(objList: List<T>) {
//        val insertResult = insert(objList)
//        val updateList = ArrayList<T>()
//
//        for (i in insertResult.indices) {
//            if (insertResult[i] == -1L) {
//                updateList[i] = objList[i]
//            }
//        }
//
//        if (!updateList.isEmpty()) {
//            update(updateList)
//        }
//    }

    /**
     * Delete old list and insert new list
     *
     * @param oldList
     */
//    @Transaction
//    fun delsert(oldList: List<T>, newList: List<T>) {
//        delete(oldList)
//        insert(newList)
//    }
}