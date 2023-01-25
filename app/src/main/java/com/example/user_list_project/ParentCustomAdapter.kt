package com.example.user_list_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




/*data class Model1(val img : Int , val name : String , val price : String)*/



/*
class CustomAdapter(private val dataset : ArrayList<Model1>): RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val textName: TextView
        val textPrice : TextView
        val imageView : ImageView

        init {

            textName = view.findViewById(R.id.txtName2)
            textPrice = view.findViewById(R.id.txtPrice2)
            imageView = view.findViewById(R.id.img2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.userlist,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textName.text = dataset[position].name
        holder.textPrice.text = dataset[position].price
        holder.imageView.setImageResource(dataset[position].img)

    }
}*/

class ParentCustomAdapter(private val dataset : ArrayList<ProductModelParent>): RecyclerView.Adapter<ParentCustomAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val parent_category: TextView
        val child_recycler : RecyclerView

        init {

            child_recycler = view.findViewById(R.id.child_recycler)
            parent_category = view.findViewById(R.id.parent_category)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.parentlist,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.parent_category.text = dataset[position].categoryName

        val childAdapter :CustomAdapter = CustomAdapter(dataset[position].arraylist)

        holder.child_recycler.layoutManager = LinearLayoutManager(holder.child_recycler.context,LinearLayoutManager.HORIZONTAL,false)

        holder.child_recycler.adapter = childAdapter

        /*childAdapter.notifyDataSetChanged()*/



    }
}