package com.oktanc71.database_homework.provider

import android.content.*
import android.database.Cursor
import android.net.Uri
import com.oktanc71.database_homework.database.AppDatabase
import com.oktanc71.database_homework.entities.ListEntity

import com.oktanc71.database_homework.repository.Repository

class ListProvider : ContentProvider() {

    private lateinit var repository: Repository

    companion object {
        const val AUTHORITY = "com.oktanc71.database_homework.provider/list"
        val uri = Uri.parse("content://" + AUTHORITY + "/" + ListEntity.TABLE_NAME)!!
        const val CODE_ALL = 1
        const val CODE_ITEM = 2
        val MATCHER = UriMatcher(UriMatcher.NO_MATCH)

        init {
            MATCHER.addURI(AUTHORITY, ListEntity.TABLE_NAME, CODE_ALL)
            MATCHER.addURI(AUTHORITY, ListEntity.TABLE_NAME + "/*", CODE_ITEM)
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        // Implement this to handle requests to delete one or more rows.
        when (MATCHER.match(uri)) {
            CODE_ALL -> {
                throw IllegalArgumentException("Invalid URI, cannot update without ID$uri");
            }
            CODE_ITEM -> {
                val count = repository.deleteList(ContentUris.parseId(uri))
                context!!.contentResolver.notifyChange(uri, null)
                return count
            }
            else -> {
                throw IllegalArgumentException("\"Unknown URI: \" + uri")
            }
        }
    }

    override fun getType(uri: Uri): String? {
        // at the given URI for getting MIME TYPE
        when (MATCHER.match(uri)) {
            CODE_ALL ->
                return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + AUTHORITY + ListEntity.TABLE_NAME
            CODE_ITEM ->
                return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + AUTHORITY + ListEntity.TABLE_NAME
            else ->
                throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        //for insertion of contentValues
        when (MATCHER.match(uri)) {
            CODE_ALL -> {
                val id = repository
                    .insertList(ListEntity.fromContentValues(values as ContentValues))
                context!!.contentResolver.notifyChange(uri, null)
                AppDatabase.getInstance(context!!).close()
                return ContentUris.withAppendedId(uri, id)
            }
            CODE_ITEM -> {
                throw IllegalArgumentException("Invalid URI, cannot insert with ID: $uri")
            }
            else -> {
                throw IllegalArgumentException("Unknown URI: $uri")
            }
        }
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val code = MATCHER.match(uri)
        if (code == CODE_ALL || code == CODE_ITEM) {
            if (code == CODE_ALL) {
                val cursor = repository.selectAllList()
                cursor.setNotificationUri(context!!.contentResolver, uri)
                return cursor
            } else {
                val cursor = repository.selectListById(ContentUris.parseId(uri))
                cursor.setNotificationUri(context!!.contentResolver, uri)
                return cursor
            }
        } else {
            throw java.lang.IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        when (MATCHER.match(uri)) {
            CODE_ALL -> {
                throw IllegalArgumentException("Invalid URI, cannot update without ID$uri");
            }
            CODE_ITEM -> {
                val entity = ListEntity.fromContentValues(values as ContentValues)
                entity.id = ContentUris.parseId(uri)
                val count = repository.updateList(entity)
                context!!.contentResolver.notifyChange(uri, null)
                return count
            }
            else -> {
                throw java.lang.IllegalArgumentException("Unknown URI: $uri")
            }
        }
    }
}
