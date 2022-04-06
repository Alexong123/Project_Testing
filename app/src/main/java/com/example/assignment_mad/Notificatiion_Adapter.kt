package com.example.assignment_mad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class NotificationAdapter(private val companyList:ArrayList<Company>): RecyclerView.Adapter<NotificationAdapter.MyViewHolder>() {

    private lateinit var mListener:onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_notification_,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=companyList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text=currentItem.heading
    }

    override fun getItemCount(): Int {
        return companyList.size
    }

    //to insert the post detail
    class MyViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){

        val titleImage: ShapeableImageView =itemView.findViewById(R.id.title_image)
        val tvHeading: TextView =itemView.findViewById(R.id.tvHeading)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

}