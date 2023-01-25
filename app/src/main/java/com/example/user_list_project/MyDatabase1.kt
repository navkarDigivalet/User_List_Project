package com.example.user_list_project

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// data class CourseModel(val name : String , val price : String , val category: String)



class MyDatabase1(
    context: Context?

) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {

        const val DATABASE_VERSION = 1
        //const val DATABASE_NAME = "UserListDB"
        const val DATABASE_NAME = "UserListDB3"
        const val TABLE_NAME = "userList"
        const val KEY_NAME = "name"
        const val KEY_PRICE = "price"
        const val KEY_CATEGORY = "category"
        const val KEY_IMAGE = "image"
    }

    override fun onCreate(db: SQLiteDatabase?) {

       // db?.execSQL("CREATE TABLE $TABLE_NAME ($KEY_NAME TEXT , $KEY_PRICE TEXT , $KEY_CATEGORY TEXT )")

        db?.execSQL("CREATE TABLE $TABLE_NAME ($KEY_NAME TEXT , $KEY_PRICE TEXT , $KEY_CATEGORY TEXT , $KEY_IMAGE BLOB)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL("drop table if exists $TABLE_NAME")

       onCreate(db)

    }

    fun addUser(name:String , price : String , category: String  , image : ByteArray)
    {
        val db : SQLiteDatabase = this.writableDatabase

        ////

        ///

        val values : ContentValues = ContentValues()

        values.put(KEY_NAME , name)
        values.put(KEY_PRICE , price)
        values.put(KEY_CATEGORY , category)
        values.put(KEY_IMAGE , image)

        db.insert(TABLE_NAME , null , values)
    }

    fun readUser() : ArrayList<ProductModel>
    {
        val db : SQLiteDatabase = this.readableDatabase

        val cursorCourses : Cursor = db.rawQuery("select  * from $TABLE_NAME" , null)

        val courseModelArrayList : ArrayList<ProductModel> = ArrayList()

        if(cursorCourses.moveToFirst())
        {
            do{

             courseModelArrayList.add(ProductModel(
                    cursorCourses.getString(0),
                    cursorCourses.getString(1),
                    cursorCourses.getString(2),
                   cursorCourses.getBlob(3)
                ))

            }while(cursorCourses.moveToNext())
        }
        cursorCourses.close()
        return courseModelArrayList
    }

    fun readCategory(category: String): ArrayList<ProductModel>
    {
        val db : SQLiteDatabase = this.readableDatabase

        val cursorCourses : Cursor = db.rawQuery("select * from $TABLE_NAME where $KEY_CATEGORY = \"$category\""  , null)

        val courseModelArrayList : ArrayList<ProductModel> = ArrayList()

        if(cursorCourses.moveToFirst())
        {
            do{
                courseModelArrayList.add(ProductModel(cursorCourses.getString(0),cursorCourses.getString(1),cursorCourses.getString(2),
                    cursorCourses.getBlob(3)
                ))
            }while(cursorCourses.moveToNext())
        }
        cursorCourses.close()
        return courseModelArrayList
    }
}