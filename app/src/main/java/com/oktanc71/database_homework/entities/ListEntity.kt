package com.oktanc71.database_homework.entities

import android.content.ContentValues
import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ListEntity.TABLE_NAME)
data class ListEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    var id:Long = 0,
    @ColumnInfo(name = ListEntity.NAME)
    var name:String,
    @ColumnInfo(name = ListEntity.DATE)
    var date:Int,
    @ColumnInfo(name = ListEntity.DESCRIPTION)
    var description:String?
){
    companion object {

        const val COLUMN_ID = BaseColumns._ID
        const val TABLE_NAME = "lists"
        const val NAME = "name"
        const val DATE = "date"
        const val DESCRIPTION = "description"
        fun fromContentValues(vals: ContentValues): ListEntity {
            val entity= ListEntity(0,"",0,"");
            if (vals.containsKey(COLUMN_ID)) {
                entity.id = vals.getAsLong(COLUMN_ID)
            }
            if (vals.containsKey(NAME)) {
                entity.name = vals.getAsString(NAME)
            }
            if (vals.containsKey(DATE)) {
                entity.date = vals.getAsInteger(DATE)
            }
            if (vals.containsKey(DESCRIPTION)) {
                entity.description = vals.getAsString(DESCRIPTION)
            }
            return entity
        }
    }
}

