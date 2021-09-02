package com.example.gadsnotekeeperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.gadsnotekeeperapp.databinding.ActivityMainBinding
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner


class MainActivity : AppCompatActivity() {

    private var notePosition = POSITION_NOT_SET

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        var spinnerAdapter =  ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,DataManager.courses.values.toList(),)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        var spinner: Spinner = findViewById(R.id.spinnerCourse)
        spinner.adapter = spinnerAdapter

        notePosition = intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET)

        if (notePosition != POSITION_NOT_SET) {
            displayNote()
        }
        else {
            DataManager.notes.add(NoteInfo())
            notePosition = DataManager.notes.lastIndex
        }
    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        val noteTitle : EditText = findViewById(R.id.noteText)
        val noteText : EditText = findViewById(R.id.noteTitle)

        noteTitle.setText(note.title)
        noteText.setText(note.text)


        val coursePosition = DataManager.courses.values.indexOf(note.course)
        val spinna:Spinner = findViewById(R.id.spinnerCourse)

        spinna.setSelection(coursePosition)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }
}