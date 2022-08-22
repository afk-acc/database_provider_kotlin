package com.oktanc71.database_homework.entities

import android.content.ContentValues
import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ProductEntity.TABLE_NAME)
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    var id: Long ,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = COUNT)
    var count: Double,
    @ColumnInfo(name = LIST_ID)
    var list_id:Int,
    @ColumnInfo(name = CHECKED)
    var checked:Int,
    @ColumnInfo(name = COUNT_TYPE)
    var count_type:Int
){
    companion object {

        const val COLUMN_ID = BaseColumns._ID
        const val TABLE_NAME = "product"
        const val NAME = "name"
        const val COUNT = "count"
        const val LIST_ID = "list_id"
        const val CHECKED = "checked"
        const val COUNT_TYPE = "count_type"
        fun fromContentValues(vals: ContentValues): ProductEntity {
            val entity= ProductEntity(0,"",0.0,0,0,0);
            if (vals.containsKey(COLUMN_ID)) {
                entity.id = vals.getAsLong(COLUMN_ID)
            }
            if (vals.containsKey(NAME)) {
                entity.name = vals.getAsString(NAME)
            }
            if (vals.containsKey(COUNT)) {
                entity.count = vals.getAsDouble(COUNT)
            }
            if (vals.containsKey(LIST_ID)) {
                entity.list_id = vals.getAsInteger(LIST_ID)
            }
            if (vals.containsKey(CHECKED)) {
                entity.checked = vals.getAsInteger(CHECKED)
            }
            if (vals.containsKey(COUNT_TYPE)) {
                entity.count_type = vals.getAsInteger(CHECKED)
            }
            return entity
        }
    }
}

