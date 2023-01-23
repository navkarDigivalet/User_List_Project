package com.example.user_list_project

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class AddUser : AppCompatActivity() {

    lateinit var txtName : TextView
    lateinit var  txtPrice : TextView
    lateinit var edtName : EditText
    lateinit var edtPrice : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolBar)

        setSupportActionBar(toolbar)



        val categories = resources.getStringArray(R.array.categories)

        val spinner: Spinner = findViewById(R.id.Spinner1)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, categories
        )
        spinner.adapter = adapter

        // val mydb1 : MyDatabase1 = MyDatabase1(this)          //creating the database

        //  mydb1.addUser("Navkar" , "90000")




        val txtBack : TextView = findViewById(R.id.txtBack)
        val txtSave : TextView = findViewById(R.id.txtSave)

        txtSave.setOnClickListener {

            val dbHandler : MyDatabase1 = MyDatabase1(this)

            txtName = findViewById(R.id.txtName)
            txtPrice = findViewById(R.id.txtPrice)

            edtName = findViewById(R.id.edtName)
            edtPrice = findViewById(R.id.edtPrice)

            var stringName : String = edtName.text.toString()
            var stringPrice : String = edtPrice.text.toString()
            var stringCategory : String = spinner.selectedItem.toString()

            ///
            /*val intentData = Intent(applicationContext,ShowUser::class.java)
            intent.putExtra("category_name",stringCategory)*/

            val sharedPref = getSharedPreferences("myKey", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("value", stringCategory)
            editor.apply()

            ///

            if(stringName.isEmpty() && stringPrice.isEmpty()){
                Toast.makeText(applicationContext, "Please enter all the data..", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            dbHandler.addUser(stringName,stringPrice,stringCategory)
            Toast.makeText(applicationContext,"Data Inserted" ,Toast.LENGTH_SHORT).show()
            edtName.text = null
            edtPrice.text = null
        }

        txtBack.setOnClickListener {
            val intent1 = Intent(this , MainActivity::class.java)
            startActivity(intent1)
        }


    }
}