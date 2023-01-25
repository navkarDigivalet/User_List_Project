package com.example.user_list_project

import android.widget.ImageView

data class ProductModel(val name: String, val price: String, val category: String ,val image: ByteArray)

// data class CourseModel(val name : String , val price : String ,)

data class ProductModelParent(val categoryName : String , val arraylist: ArrayList<ProductModel>)