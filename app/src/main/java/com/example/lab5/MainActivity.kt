package com.example.lab5

import GridAdapter
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val items = List(28) {
            GridItem(
                value = (1..99).random(),
                color = Color.rgb((0..255).random(), (0..255).random(), (0..255).random())
            )
        }

        val adapter = GridAdapter(items) { item ->
            showNumberDialog(item.value)
        }
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 4)
    }

    private fun showNumberDialog(value: Int) {
        AlertDialog.Builder(this)
            .setTitle("Number")
            .setMessage("You choose number: $value")
            .setPositiveButton("OK", null)
            .show()
    }
}
