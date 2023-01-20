package com.example.routeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class addcourse_screen : AppCompatActivity() {

    lateinit var course_title : EditText
    lateinit var course_content : EditText
    lateinit var addcourse :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcourse_screen)
        initViews()
    }

    fun initViews(){
        course_title =findViewById(R.id.course_title)
        course_content=findViewById(R.id.course_content)
        addcourse = findViewById(R.id.addcourse)
        addcourse.setOnClickListener(object :OnClickListener{
            override fun onClick(p0: View?){
               val title:String=course_title.text.toString()
               val content=course_content.text.toString()
                if(title.isNotEmpty()&&content.isNotEmpty()){
               val intent1= Intent()
               intent1.putExtra(constants.EXTRA_TITLE,title)
               intent1.putExtra(constants.Extra_CONTENT,content)

               setResult(RESULT_OK,intent1)
                finish()
                }else{
                    Toast.makeText(this@addcourse_screen,"please Enter the course title and content",Toast.LENGTH_LONG).show()
                }
            }


        })



    }
}