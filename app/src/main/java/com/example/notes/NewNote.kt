package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class NewNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

        val saveButton = findViewById<Button>(R.id.save_note)

        saveButton.setOnClickListener {
            val titleText = findViewById<EditText>(R.id.title).text.toString()
            val titleDescription = findViewById<EditText>(R.id.description).text.toString()

            val db = DBHelper(this, null)

            db.addNote(titleText, titleDescription)
            Toast.makeText(this, "Added to database", Toast.LENGTH_LONG).show()

            val mainMenuIntent = Intent(this, MainActivity::class.java)
            startActivity(mainMenuIntent)
        }

    }

}
