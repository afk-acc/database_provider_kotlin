package com.oktanc71.database_homework.entities

import android.content.ContentValues
import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TypeEntity.TABLE_NAME)
data class TypeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = TypeEntity.COLUMN_ID)
    var id: Long,
    @ColumnInfo(name = TypeEntity.LABEL)
    var label: String,
    @ColumnInfo(name = TypeEntity.RULE)
    var rule: String,
)
{    companion object {
        const val COLUMN_ID = BaseColumns._ID
        const val TABLE_NAME = "type"
        const val LABEL = "label"
        const val RULE = "rule"
        fun fromContentValues(vals: ContentValues): TypeEntity {
            val entity= TypeEntity(0,"","");
            if (vals.containsKey(COLUMN_ID)) {
                entity.id = vals.getAsLong(COLUMN_ID)
            }
            if (vals.containsKey(LABEL)) {
                entity.label = vals.getAsString(LABEL)
            }
            if (vals.containsKey(RULE)) {
                entity.rule = vals.getAsString(RULE)
            }
            return entity
        }
    }
}

