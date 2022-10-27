package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        val seeNotesBtn = findViewById<Button>(R.id.see_notes)
        val newNoteBtn = findViewById<Button>(R.id.add_note)
        val clearData = findViewById<Button>(R.id.clear_cache)


        newNoteBtn.setOnClickListener {
            val intent = Intent(this, NewNote::class.java)
            startActivity(intent)
        }

        seeNotesBtn.setOnClickListener {
            val intent = Intent(this, ShowNotes::class.java)
            startActivity(intent)
        }

        clearData.setOnClickListener {
            val prefs = getSharedPreferences("com.example.notes", MODE_PRIVATE)
            prefs.edit().clear().apply()
            Toast.makeText(this, "Cache has been cleared", Toast.LENGTH_SHORT).show()
        }


    }




}