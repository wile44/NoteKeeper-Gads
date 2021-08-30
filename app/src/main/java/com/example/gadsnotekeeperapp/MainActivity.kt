package com.example.gadsnotekeeperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gadsnotekeeperapp.databinding.ActivityMainBinding
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        var spinnerAdapter =  ArrayAdapter<CourseInfo>(this,android.R.layout.simple_spinner_item,DataManager.courses.values.toList(),)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCourse.adapter = spinnerAdapter
    }
}