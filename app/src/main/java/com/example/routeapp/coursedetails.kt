package com.example.routeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class coursedetails : AppCompatActivity() {
      var title :String ?=null
      var content :String ?=null


    lateinit var contenttextview :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coursedetails)

        title=intent.getStringExtra(constants.EXTRA_TITLE)
        content=intent.getStringExtra(constants.Extra_CONTENT)


        contenttextview = findViewById(R.id.contentt)
        contenttextview.text = content
    }
}