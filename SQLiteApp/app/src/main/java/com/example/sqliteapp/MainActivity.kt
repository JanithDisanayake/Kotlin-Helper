package com.example.sqliteapp

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    var db = Database(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        db!!.insertData("Nimal", "Badulla")
        db!!.updateData(1, "NAME", "Janith")
        Log.w("Students", db!!.readData().toString())
    }

}