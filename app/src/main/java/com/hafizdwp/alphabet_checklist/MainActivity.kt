package com.hafizdwp.alphabet_checklist

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafizdwp.alphabet_checklist.base.BaseActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        adapter = MainAdapter()
        recycler_view.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}