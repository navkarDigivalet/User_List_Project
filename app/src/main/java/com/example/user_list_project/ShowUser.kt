package com.example.user_list_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ShowUser : AppCompatActivity() {

    lateinit var  arrayUser : ArrayList<CourseModel>
    lateinit var dbHandler : MyDatabase1
    lateinit var recyclerView: RecyclerView
    lateinit var customAdapter: CustomAdapter

    ////
    lateinit var arrayParentUser : ArrayList<CourseModelParent>
    lateinit var parentCustomAdapter: ParentCustomAdapter

    lateinit var arrayListCategory1 : ArrayList<CourseModel>
    lateinit var arrayListCategory2 : ArrayList<CourseModel>
    lateinit var arrayListCategory3 : ArrayList<CourseModel>
    lateinit var arrayListCategory4 : ArrayList<CourseModel>
    lateinit var arrayListCategory5 : ArrayList<CourseModel>
    ///

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_user)


       /* val intentData = intent
        val categoryName : String = intentData.getStringExtra("category_name").toString()*/

        val sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE)
        val categoryName = sharedPreferences.getString("value", "").toString()
       //  Log.d("this" , "Data stored is $categoryName")




        arrayUser = ArrayList<CourseModel>()
        dbHandler = MyDatabase1(this)

         arrayUser = dbHandler.readUser()

        arrayListCategory1 = ArrayList()
        arrayListCategory2 = ArrayList()
        arrayListCategory3 = ArrayList()
        arrayListCategory4 = ArrayList()
        arrayListCategory5 = ArrayList()

        arrayListCategory1 = dbHandler.readCategory("Category 1")
        arrayListCategory2 = dbHandler.readCategory("Category 2")
        arrayListCategory3 = dbHandler.readCategory("Category 3")
        arrayListCategory4 = dbHandler.readCategory("Category 4")
        arrayListCategory5 = dbHandler.readCategory("Category 5")

        /*arrayUser.add(CourseModel("fefef","64646"))
        arrayUser.add(CourseModel("wfwf","58585"))
        arrayUser.add(CourseModel("feffwfwef","58585"))
        arrayUser.add(CourseModel("wfwf","8585"))
        arrayUser.add(CourseModel("fefhgthef","64658546"))*/

        recyclerView = findViewById(R.id.Recycler1)

        recyclerView.layoutManager = LinearLayoutManager(this)

        customAdapter = CustomAdapter(arrayUser)

      /*  arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 1" , "500000"))
        arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 2" , "500000"))
        arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 3" , "500000"))
        arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 4" , "500000"))
        arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 5" , "500000"))
        arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 6" , "500000"))
        arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 7" , "500000"))
        arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 8" , "500000"))
        arrayUser.add(Model1(R.drawable.ic_launcher_background,"Product 9" , "500000"))*/

        /////

        arrayParentUser = ArrayList()
        arrayParentUser.add(CourseModelParent("Category 1" , arrayListCategory1))
        arrayParentUser.add(CourseModelParent("Category 2" , arrayListCategory2))
        arrayParentUser.add(CourseModelParent("Category 3" , arrayListCategory3))
        arrayParentUser.add(CourseModelParent("Category 4" , arrayListCategory4))
        arrayParentUser.add(CourseModelParent("Category 5" , arrayListCategory5))


        parentCustomAdapter = ParentCustomAdapter(ArrayList(arrayParentUser))



        ////




        recyclerView.adapter = parentCustomAdapter




    }
}