package com.example.notes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {

        val query = ("CREATE TABLE $TABLE_NAME($ID_COL INTEGER PRIMARY KEY, $TITLE_COl TEXT, $DESCRIPTION_COL TEXT)")

        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)

    }

    fun addNote(title: String, description: String) {
        val values = ContentValues()
        values.put(TITLE_COl, title)
        values.put(DESCRIPTION_COL, description)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()

    }

    fun getNotes(): Cursor? {

        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)

    }

    fun deleteNotes(): Unit? {
        val db = this.readableDatabase
        return db?.execSQL("DELETE FROM $TABLE_NAME")

    }

    companion object {
        private val DATABASE_NAME = "NOTES"
        private val DATABASE_VERSION = 1

        val ID_COL = "id"
        val TABLE_NAME = "notes_table"

        val TITLE_COl = "title"
        val DESCRIPTION_COL = "description"

    }

}