package com.example.sqliteapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Database(val context: Context) :  SQLiteOpenHelper(context, "NIBM", null, 1){

    override fun onCreate(db: SQLiteDatabase?)
    {
        val student = "CREATE TABLE Student(ST_ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT DEFAULT '', ADDRESS TEXT DEFAULT '')"
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

    fun readData() : ArrayList<Student>
    {
        val db = this.writableDatabase
        val query = "SELECT * FROM Student"
        val students = ArrayList<Student>()
        var result = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            do {
                var student = Student()
                student.id = result.getInt(0)
                student.name = result.getString(1)
                student.addr = result.getString(2)
                students.add(student)
            }
            while (result.moveToNext())
        }
        result.close()
        db.close()
        return students
    }

    fun updateData(id :Int, field :String, value :String) : Boolean
    {
        try {
            val database = this.writableDatabase
            database.execSQL("UPDATE Student SET $field = '$value' WHERE ST_ID = $id")
        }
        catch (e: java.lang.Exception) {
            e.printStackTrace()
            return false
        }
        return true
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
    
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}