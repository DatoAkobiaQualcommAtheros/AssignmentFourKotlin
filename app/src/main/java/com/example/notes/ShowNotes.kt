package com.example.notes

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowNotes: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_notes)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(generateFakeValues())

    }


    private fun generateFakeValues(): List<Pair<String, Any?>> {
        Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show()
        val prefs = getSharedPreferences("com.example.notes", MODE_PRIVATE)
        val all = prefs.all

       return all.toList()
    }

    class Adapter(private val values: List<Pair<String, Any?>>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

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
            for (elem in values.toList()) {
                holder.textiew?.text = values[position].toList()[0] as CharSequence?

                }

                holder.textDescription?.text = values[position].toList().toString()
            }

        }


    }



