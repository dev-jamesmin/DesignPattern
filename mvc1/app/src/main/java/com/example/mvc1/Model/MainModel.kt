package com.example.mvc1.Model

import android.content.Context

//Model
class MainModel(private val context: Context) {

    fun getListDatas(): ArrayList<String> {
        val datas: ArrayList<String> = ArrayList<String>()

        //dbms
        val helper = DBHelper(context)
        val db = helper.readableDatabase
        val cursor = db.rawQuery("select * from tb_test", null)
        while (cursor.moveToNext()) {
            datas.add(cursor.getString(1))
        }

        db.close()
        return datas

    }

    fun addItem(item: String) {

        val helper = DBHelper(context)
        val db = helper.writableDatabase

        db.execSQL("insert into tb_test (todo) values (?)", arrayOf(item))
        db.close()
    }
}

