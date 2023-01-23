package com.example.user_list_project

 data class CourseModel(val name : String , val price : String , val category: String)

// data class CourseModel(val name : String , val price : String ,)

data class CourseModelParent(val categoryName : String , val arraylist: ArrayList<CourseModel>)