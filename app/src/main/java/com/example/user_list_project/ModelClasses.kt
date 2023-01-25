package com.example.user_list_project



data class ProductModel(val name: String, val price: String, val category: String ,val image: ByteArray)

// data class CourseModel(val name : String , val price : String ,)

data class ProductModelParent(val categoryName : String , val arraylist: ArrayList<ProductModel>)