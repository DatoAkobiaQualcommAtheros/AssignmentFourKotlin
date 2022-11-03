package com.example.notes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowNotes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_notes)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(titleGenerate(), descriptionGenerate())

    }

    @SuppressLint("Range")
    private fun titleGenerate(): MutableList<String> {
        val db = DBHelper(this, null)
        val list = mutableListOf<String>()
        val cursor = db.getNotes()
        cursor!!.moveToFirst()

        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex(DBHelper.TITLE_COl)))

        }

        return list
    }

    @SuppressLint("Range")
    private fun descriptionGenerate(): MutableList<String> {
        val db = DBHelper(this, null)
        val list = mutableListOf<String>()
        val cursor = db.getNotes()
        cursor!!.moveToFirst()

        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex(DBHelper.DESCRIPTION_COL)))

        }

        return list
    }

    class Adapter(
        private val values: MutableList<String>,
        private val descriptionValues: MutableList<String>
    ) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun getItemCount(): Int = values.size

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textiew: TextView? = null
            var textDescription: TextView? = null

            init {
                textiew = itemView.findViewById(R.id.text_list_item)
                textDescription = itemView.findViewById(R.id.text_list_description)
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.text_list_view, parent, false)
            return ViewHolder(itemView)
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.textiew?.text = values[position]
            holder.textDescription?.text = "Some_Random"


        }

    }


}



