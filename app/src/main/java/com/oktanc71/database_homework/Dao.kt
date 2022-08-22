package com.oktanc71.database_app

import android.database.Cursor
import androidx.room.*
import androidx.room.Dao
import com.oktanc71.database_homework.entities.ListEntity
import com.oktanc71.database_homework.entities.ProductEntity
import com.oktanc71.database_homework.entities.TypeEntity

@Dao
interface Dao {

    @Query("SELECT * FROM " + ProductEntity.TABLE_NAME + " WHERE " + ProductEntity.COLUMN_ID + " = :id")
    fun selectProductById(id: Long): Cursor

    @Query("SELECT * FROM " + ProductEntity.TABLE_NAME)
    fun selectAllProduct(): Cursor

    @Query("SELECT * from " + ProductEntity.TABLE_NAME)
    fun getAllProduct(): List<ProductEntity>

    @Insert
    fun insertProduct(product: ProductEntity): Long

    @Update
    fun updateProduct(product: ProductEntity):Int

    @Query("DELETE FROM " + ProductEntity.TABLE_NAME + " WHERE " + ProductEntity.COLUMN_ID + " = :id")
    fun deleteProduct(id: Long): Int

    @Query("SELECT * FROM " + ListEntity.TABLE_NAME + " WHERE " + ListEntity.COLUMN_ID + " = :id")
    fun selectListById(id: Long): Cursor

    @Query("SELECT * FROM " + ListEntity.TABLE_NAME)
    fun selectAllList(): Cursor

    @Query("SELECT * from " + ListEntity.TABLE_NAME)
    fun getAllList(): List<ListEntity>

    @Insert
    fun insertList(list: ListEntity): Long

    @Update
    fun updateList(list: ListEntity):Int

    @Delete
    @Query("DELETE FROM " + ListEntity.TABLE_NAME + " WHERE " + ListEntity.COLUMN_ID + " = :id")
    fun deleteList(id: Long): Int

    @Query("SELECT * FROM " + TypeEntity.TABLE_NAME + " WHERE " + TypeEntity.COLUMN_ID + " = :id")
    fun selectTypeById(id: Long): Cursor

    @Query("SELECT * FROM " + TypeEntity.TABLE_NAME)
    fun selectAllType(): Cursor

    @Query("SELECT * from " + TypeEntity.TABLE_NAME)
    fun getAllType(): List<TypeEntity>

    @Insert
    fun insertType(type: TypeEntity): Long

    @Update
    fun updateType(type: TypeEntity):Int

    @Delete
    @Query("DELETE FROM " + TypeEntity.TABLE_NAME + " WHERE " + TypeEntity.COLUMN_ID + " = :id")
    fun deleteType(id: Long): Int
}