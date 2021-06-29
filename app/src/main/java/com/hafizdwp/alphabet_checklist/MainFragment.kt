package com.hafizdwp.alphabet_checklist

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafizdwp.alphabet_checklist.base.BaseFragment
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * @author hafizdwp
 * 29/06/2021
 **/
class MainFragment : BaseFragment<MainActivity>(), MainActionListener {

    override val layoutRes: Int
        get() = R.layout.main_fragment

    lateinit var adapter: MainAdapter
    lateinit var addDialog: MainAddDialog
    lateinit var viewModel: MainViewModel

    override fun onViewReady(view: View) {
        viewModel = obtainViewModel()

        adapter = MainAdapter()
        recycler_view.apply {
            adapter = this@MainFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        addDialog = MainAddDialog(requireContext(), this)

        fab_add.setOnClickListener {
            addDialog.show()
        }
    }

    override fun addName(name: String) {
        viewModel.addName(name)
    }
}