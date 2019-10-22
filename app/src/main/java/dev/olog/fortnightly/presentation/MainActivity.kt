package dev.olog.fortnightly.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.olog.fortnightly.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.adapter = SimpleAdapter()
        list.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        list.addOnScrollListener(listener)
    }

    override fun onPause() {
        super.onPause()
        list.removeOnScrollListener(listener)
    }

    private val listener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            toolbar.translate(dy)
        }
    }

}

class SimpleHolder(view: View) : RecyclerView.ViewHolder(view)

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