package com.oktanc71.database_homework.repository

import android.content.Context
import android.database.Cursor
import com.oktanc71.database_app.Dao
import com.oktanc71.database_homework.database.AppDatabase
import com.oktanc71.database_homework.entities.ListEntity
import com.oktanc71.database_homework.entities.ProductEntity
import com.oktanc71.database_homework.entities.TypeEntity

class Repository(context: Context) {

    private var db: Dao = AppDatabase.getInstance(context).productsDao()

    fun selectProductById(id:Long):Cursor{
        return db.selectProductById(id)
    }

    fun selectAllProduct():Cursor{
        return db.selectAllProduct()
    }
    fun selectTypeById(id:Long):Cursor{
        return db.selectTypeById(id)
    }
    fun selectAllType():Cursor{
        return db.selectAllType()
    }
    fun selectListById(id:Long):Cursor{
        return db.selectListById(id)
    }
    fun selectAllList():Cursor{
        return db.selectAllList()
    }

    fun getAllType(): List<TypeEntity>{
        return db.getAllType()
    }

    fun insertType(type: TypeEntity):Long {
        db.insertType(type)
        return type.id
    }

    fun updateType(type: TypeEntity):Int {
        return db.updateType(type)
    }

    fun deleteType(id: Long):Int {
        return db.deleteType(id)
    }

    fun getAllProduct(): List<ProductEntity>{
        return db.getAllProduct()
    }

    fun insertProduct(product: ProductEntity):Long {
        db.insertProduct(product)
        return product.id
    }

    fun updateProduct(product: ProductEntity):Int {
        return db.updateProduct(product)
    }

    fun deleteProduct(id: Long):Int {
        return db.deleteProduct(id)
    }

    fun getAllList(): List<ListEntity>{
        return db.getAllList()
    }

    fun insertList(list: ListEntity):Long {
        db.insertList(list)
        return list.id
    }

    fun updateList(list: ListEntity):Int {
        return db.updateList(list)
    }

    fun deleteList(id: Long) :Int {
       return db.deleteList(id)
    }

}