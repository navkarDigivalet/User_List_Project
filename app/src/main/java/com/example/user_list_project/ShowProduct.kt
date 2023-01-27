package com.example.user_list_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ShowUser : AppCompatActivity() {

    private lateinit var  arrayProduct : ArrayList<ProductModel>
    private lateinit var dbHandler : MyDatabase1
    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter

    ////
    private lateinit var arrayParentProduct : ArrayList<ProductModelParent>
    private lateinit var parentCustomAdapter: ParentCustomAdapter

    /*lateinit var arrayListCategory1 : ArrayList<ProductModel>
    lateinit var arrayListCategory2 : ArrayList<ProductModel>
    lateinit var arrayListCategory3 : ArrayList<ProductModel>
    lateinit var arrayListCategory4 : ArrayList<ProductModel>
    lateinit var arrayListCategory5 : ArrayList<ProductModel>*/
    ///

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_user)


       /* val intentData = intent
        val categoryName : String = intentData.getStringExtra("category_name").toString()*/

      /*  val sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE)
        val categoryName = sharedPreferences.getString("value", "").toString()*/

       //  Log.d("this" , "Data stored is $categoryName")

        arrayProduct = ArrayList<ProductModel>()
        dbHandler = MyDatabase1(this)

         arrayProduct = dbHandler.readUser()

       /* arrayListCategory1 = ArrayList()
        arrayListCategory2 = ArrayList()
        arrayListCategory3 = ArrayList()
        arrayListCategory4 = ArrayList()
        arrayListCategory5 = ArrayList()

        arrayListCategory1 = dbHandler.readCategory("Category 1")
        arrayListCategory2 = dbHandler.readCategory("Category 2")
        arrayListCategory3 = dbHandler.readCategory("Category 3")
        arrayListCategory4 = dbHandler.readCategory("Category 4")
        arrayListCategory5 = dbHandler.readCategory("Category 5")*/

        /*arrayUser.add(CourseModel("fefef","64646"))
        arrayUser.add(CourseModel("wfwf","58585"))
        arrayUser.add(CourseModel("feffwfwef","58585"))
        arrayUser.add(CourseModel("wfwf","8585"))
        arrayUser.add(CourseModel("fefhgthef","64658546"))*/

        recyclerView = findViewById(R.id.Recycler1)

        recyclerView.layoutManager = LinearLayoutManager(this)

        customAdapter = CustomAdapter(arrayProduct)

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

        val arrCategory1  : ArrayList<ProductModel> = ArrayList(arrayProduct.size)
        val arrCategory2  : ArrayList<ProductModel> = ArrayList(arrayProduct.size)
        val arrCategory3  : ArrayList<ProductModel> = ArrayList(arrayProduct.size)
        val arrCategory4  : ArrayList<ProductModel> = ArrayList(arrayProduct.size)
        val arrCategory5  : ArrayList<ProductModel> = ArrayList(arrayProduct.size)

//        for(i in 0 until arrayProduct.size)
//        {
//           //arrCategory[i] = arrayUser[i].category
//           try {
//
//               when (arrayProduct[i].category) {
//                   "Category 1" -> {
//                       arrCategory1.add(arrayProduct[i])
//                   }
//                   "Category 2" -> {
//                       arrCategory2.add(arrayProduct[i])
//                   }
//                   "Category 3" -> {
//                       arrCategory3.add(arrayProduct[i])
//                   }
//                   "Category 4" -> {
//                       arrCategory4.add(arrayProduct[i])
//                   }
//                   "Category 5" -> {
//                       arrCategory5.add(arrayProduct[i])
//                   }
//               }
//              // arrCategory.add(arrayUser[i])
//           }
//
//           catch (e:Exception)
//           {
//               Log.d("Exception" , e.toString())
//           }
//        }
        arrayProduct.forEach{
            when (it.category) {
                "Category 1" -> {
                    arrCategory1.add(it)
                }
                "Category 2" -> {
                    arrCategory2.add(it)
                }
                "Category 3" -> {
                    arrCategory3.add(it)
                }
                "Category 4" -> {
                    arrCategory4.add(it)
                }
                "Category 5" -> {
                    arrCategory5.add(it)
                }
                else ->{

                }
            }
        }


//           arrayProduct.sortBy { it.category }

        /*for(i in arrayProduct)
        {
            Log.d("abc" , i.category)
        }*/

        /*val map : Map<String , ArrayList<CourseModel>> = arrayUser.associate {
            Pair(it.category, arrayUser)
        }*/

        // val map : List<Pair<String, ArrayList<ProductModel>>> = arrayProduct.map { it.category to arrayProduct }

        // Log.d("Map" , "$map")

       ////


        // arrayUser[2].category


        arrayParentProduct = ArrayList()
        arrayParentProduct.add(ProductModelParent("Category 1" , arrCategory1))
        arrayParentProduct.add(ProductModelParent("Category 2" , arrCategory2))
        arrayParentProduct.add(ProductModelParent("Category 3" , arrCategory3))
        arrayParentProduct.add(ProductModelParent("Category 4" , arrCategory4))
        arrayParentProduct.add(ProductModelParent("Category 5" , arrCategory5))





        parentCustomAdapter = ParentCustomAdapter(ArrayList(arrayParentProduct))

        recyclerView.adapter = parentCustomAdapter




    }
}