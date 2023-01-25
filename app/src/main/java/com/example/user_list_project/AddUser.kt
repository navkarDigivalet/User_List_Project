package com.example.user_list_project

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64.encodeToString
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.ByteArrayOutputStream
import java.util.Base64


class AddUser : AppCompatActivity() {

    lateinit var txtName : TextView
    lateinit var  txtPrice : TextView
    lateinit var edtName : EditText
    lateinit var edtPrice : EditText

    lateinit var btnGallery: Button
    lateinit var fabGallery: FloatingActionButton

    lateinit var  image : ByteArray

    var isImageAdded : Boolean = false

    // private const val GALLERY_REQ_CODE = 1000           // It can store any value


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

        val img1 = findViewById<ImageView>(R.id.img1)

       // btnGallery = findViewById(R.id.btnGallery)
       // fabGallery = findViewById(R.id.fabGallery)



        val resultContract = registerForActivityResult(ActivityResultContracts.GetContent()){ result->
            img1.setImageURI(result)

           //* imagePath = result!!  // If not null then assigned to it


        }

        //// Image from gallery


      img1.setOnClickListener {

            //val iGallery = Intent(Intent.ACTION_PICK)  // Picking image from gallery
            // iGallery.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI          // set a uri for using external data
            // startActivityForResult(iGallery,GALLERY_REQ_CODE)

           resultContract.launch("image/*")
            isImageAdded = true
       }



        txtSave.setOnClickListener {



            txtName = findViewById(R.id.txtName)
            txtPrice = findViewById(R.id.txtPrice)

            edtName = findViewById(R.id.edtName)
            edtPrice = findViewById(R.id.edtPrice)

            var stringName : String = edtName.text.toString()
            var stringPrice : String = edtPrice.text.toString()
            var stringCategory : String = spinner.selectedItem.toString()

            ///

            val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_add_a_photo_24)


            if(isImageAdded) {

                val bitmap = (img1.drawable as BitmapDrawable).bitmap

                val stream = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
                image = stream.toByteArray()
                val imagestr: String = android.util.Base64.encodeToString(image, 1)

            }
            else
            {
                 Toast.makeText(applicationContext , "Please upload an image...",Toast.LENGTH_SHORT).show()
                      return@setOnClickListener


            }
            ///

            val dbHandler  = MyDatabase1(this)

            ///
            /*val intentData = Intent(applicationContext,ShowUser::class.java)
            intent.putExtra("category_name",stringCategory)*/

           /* val sharedPref = getSharedPreferences("myKey", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("value", stringCategory)
            editor.apply()
*/
            ///

            if(stringName.isEmpty() && stringPrice.isEmpty() ){
                Toast.makeText(applicationContext, "Please enter all the data..", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            /*if(img1.equals(R.drawable.ic_baseline_add_a_photo_24))
            {
                Toast.makeText(applicationContext , "Please upload an image...",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }*/

            dbHandler.addUser(stringName, stringPrice, stringCategory,image)
            Toast.makeText(applicationContext,"Data Inserted" ,Toast.LENGTH_SHORT).show()
            edtName.text = null
            edtPrice.text = null
            img1.setImageResource(R.drawable.ic_baseline_add_a_photo_24)
            isImageAdded = false
        }



        txtBack.setOnClickListener {
            val intent1 = Intent(this , MainActivity::class.java)
            startActivity(intent1)
        }

        ////





    }

        //

}