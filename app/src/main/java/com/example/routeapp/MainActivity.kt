package com.example.routeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var courses_recyclerView: RecyclerView
    lateinit var adapter :courses_adapter

    lateinit var addbutton : FloatingActionButton

    lateinit var coursesList: ArrayList<course_data>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        courses_recyclerView = findViewById(R.id.courses_recyclerview)

       adapter = courses_adapter(null)
        courses_recyclerView.adapter=adapter
        adapter.onclicklistener = object :onclicklistener{
            override fun OnCourseClick(itemClicked: course_data) {
                val intent =Intent(this@MainActivity,coursedetails::class.java)
                intent.putExtra(constants.EXTRA_TITLE,itemClicked.c_name)
                intent.putExtra(constants.Extra_CONTENT,itemClicked.coursecontent)

                startActivity(intent)
            }
        }
        initData()
        addbutton = findViewById(R.id.add)
        adapter.setData(coursesList)}
       override  fun onStart() {
            super.onStart()

           val activityresult= registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback <ActivityResult>{

                    if(it.resultCode== RESULT_OK){
                        val intent1 = it.data
                        val title = intent1?.getStringExtra(constants.EXTRA_TITLE)
                        var content =  intent1?.getStringExtra(constants.Extra_CONTENT)
                        coursesList.add(
                            course_data(
                                R.drawable.android ,
                                "$title",
                                "$content"

                            )
                        )
                        adapter.setData(coursesList)
                    }

                })

        addbutton.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@MainActivity,addcourse_screen::class.java)
                activityresult.launch(intent)


            }
        }

        )
    }


    fun initData(){
         coursesList =ArrayList<course_data>()
        coursesList.add(course_data(R.drawable.android,"Android Diploma"
        ,constants.androidcontent))


        coursesList.add(course_data(R.drawable.fullstack,"Fullstack Diploma",
        constants.fullstack))


        coursesList.add(course_data(R.drawable.ios,"IOS Diploma"
        ,constants.ios))

        adapter.setData(coursesList)

    }
}