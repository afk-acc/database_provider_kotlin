package com.oktanc71.database_homework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oktanc71.database_app.Dao
import com.oktanc71.database_homework.entities.ListEntity
import com.oktanc71.database_homework.entities.ProductEntity
import com.oktanc71.database_homework.entities.TypeEntity

@Database(
    entities = [
        TypeEntity::class,
        ProductEntity::class,
        ListEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productsDao(): Dao
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "products.db"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }

}
