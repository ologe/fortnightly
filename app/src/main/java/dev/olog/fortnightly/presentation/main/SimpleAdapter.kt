package dev.olog.fortnightly.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.olog.fortnightly.R

class SimpleAdapter : RecyclerView.Adapter<SimpleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item, parent, false)
        return SimpleHolder(view)
    }

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: SimpleHolder, position: Int) {

    }
}