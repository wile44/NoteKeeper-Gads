package com.example.gadsnotekeeperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.gadsnotekeeperapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainNoteListActivity : AppCompatActivity() {

    private var notePosition = POSITION_NOT_SET

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main_note_list)

        var fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        var listView: ListView = findViewById(R.id.listView)
        listView.adapter =  ArrayAdapter(this,android.R.layout.simple_list_item_1,DataManager.notes)



        fab.setOnClickListener{ view ->
            val activityIntent = Intent(this,MainActivity::class.java)
            startActivity(activityIntent)
        }

        listView.setOnItemClickListener{ parent, view,position,id ->
            val activityIntent = Intent(this,MainActivity::class.java)
            activityIntent.putExtra(NOTE_POSITION,position)
            startActivity(activityIntent)
        }


    }

    override fun onResume() {
        super.onResume()
        var listNote = findViewById<ListView>(R.id.listView)
        (listNote.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()

    }
}