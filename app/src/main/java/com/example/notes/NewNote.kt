package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class NewNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)
        val sets: MutableSet<String> = HashSet()
        val prefs = getSharedPreferences("com.example.notes", MODE_PRIVATE)
        val saveButton = findViewById<Button>(R.id.save_note)

        saveButton.setOnClickListener {
            val titleText = findViewById<EditText>(R.id.title).text
            val titleDescription = findViewById<EditText>(R.id.description).text

            sets.add(titleText.toString())
            sets.add(titleDescription.toString())

            prefs.edit().putStringSet(titleText.toString(), sets).apply()

            val mainMenuIntent = Intent(this, MainActivity::class.java)
            startActivity(mainMenuIntent)
        }

    }

}
