package com.example.routeapp

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class courses_adapter(var courses: ArrayList<course_data>?):Adapter <courses_adapter.CoursesViewHolder>() {


var onclicklistener : onclicklistener ?= null

    class CoursesViewHolder(val itemView: View): ViewHolder(itemView){
            val c_image:ImageView
            val c_name :Button
            init{
                 c_image=itemView.findViewById(R.id.image_course)
                 c_name=itemView.findViewById(R.id.course_name)
            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.courses_item,parent,false)
        return CoursesViewHolder(view)
    }


    fun setData (courseList : ArrayList<course_data>){
        this.courses = courseList
        notifyDataSetChanged() // refresh data
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        val courseitem =courses?.get(position)!!
        holder.c_name.text=courseitem?.c_name
        holder.c_image.setImageResource(courseitem.c_image?:R.drawable.splash_screen)
        holder.itemView.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                onclicklistener?.OnCourseClick(courseitem)
            }

        })
    }

    override fun getItemCount(): Int {
        return courses?.size?:0
    }
}