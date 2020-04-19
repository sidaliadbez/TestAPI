package com.example.testapi


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview.view.*


class ApiAdapter(val context: Context, var homeFeed: HomeFeed): RecyclerView.Adapter<ApiAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(pay: String, pos: Int) {
            itemView.nameView.text = pay
            itemView.descriptionView.text= pay
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return homeFeed.data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pay = homeFeed.data[position].country
        holder.setData(pay,position)
    }

}