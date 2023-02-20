package com.example.sqliteapp

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var db:Database ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Database(this)
    }

    private fun insertData() {
        val sqlQuery1 = "INSERT INTO STUDENT(NAME,ADDRESS)VALUES('Jack', 'Colombo')"
        db?.executeQuery(sqlQuery1)

        val sqlQuery2 = "INSERT INTO STUDENT(NAME,ADDRESS)VALUES('Jim', 'Matara')"

    }
}