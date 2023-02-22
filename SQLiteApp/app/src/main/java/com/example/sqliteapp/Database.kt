package com.example.sqliteapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(val context: Context) :  SQLiteOpenHelper(context, "NIBM", null, 1){

    override fun onCreate(db: SQLiteDatabase?)
    {
        val student = "CREATE TABLE Student(ST_ID int PRIMARY KEY AUTOINCREMENT, NAME TEXT DEFAULT '', ADDRESS TEXT DEFAULT '')"
        db?.execSQL(student)
    }

    fun insertData(name :String, address :String)
    {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("NAME", name)
        cv.put("ADDRESS", address)

        db.insert("Student", null, cv)
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

}