package dev.olog.fortnightly.presentation.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerAppCompatActivity
import dev.olog.fortnightly.R
import dev.olog.fortnightly.presentation.extensions.subscribe
import dev.olog.fortnightly.presentation.extensions.viewModelProvider
import dev.olog.fortnightly.utils.lazyFast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazyFast {
        viewModelProvider<MainActivityViewModel>(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.adapter = SimpleAdapter()
        list.layoutManager = LinearLayoutManager(this)

        viewModel.observeData
            .subscribe(this) {
                println(it)
            }

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

