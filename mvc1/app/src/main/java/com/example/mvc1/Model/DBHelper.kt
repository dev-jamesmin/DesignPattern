package com.example.mvc1.Model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "tb_test", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        val memoSQL = "create table tb_test " +
                "(_id integer primary key autoincrement," +
                "todo," +
                "title," +
                "content)"
        db.execSQL(memoSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table tb_test")
        onCreate(db)
    }
}