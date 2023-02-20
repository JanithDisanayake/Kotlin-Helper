package com.example.sqliteapp

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(val context: Context) :  SQLiteOpenHelper(context, NIBM, null, 1){

    override fun onCreate(db: SQLiteDatabase?) {

        val student = "CREATE TABLE Student(ST_ID int PRIMARY KEY AUTOINCREMENT, NAME TEXT DEFAULT '', ADDRESS TEXT DEFAULT '')"
        db?.execSQL(student)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun executeQuery(sql:String) : Boolean {
        try {
            val database = this.writableDatabase
            database.execSQL(sql)
        }
        catch (e: java.lang.Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }

//    private fun getData() {
//        var cursor: Cursor?=null
//        try {
//            val database = this
//            cursor = database.raw("select * FROM STUDNET")
//        }
//        catch (e: java.lang.Exception) {
//            e.printStackTrace()
//        }
//    }

}