package com.hafizdwp.alphabet_checklist

import android.view.View
import com.hafizdwp.alphabet_checklist.base.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.main_item.view.*

/**
 * @author hafizdwp
 * 29/06/2021
 **/
class MainAdapter(private val list: List<Item>) : BaseRecyclerAdapter<Item>() {

    override val layoutRes: Int
        get() = R.layout.main_item
    override val listItem: List<Item>
        get() = list

    override fun onBind(itemView: View, data: Item, position: Int) {
        itemView.apply {
            if (data.alphabet != "") {
                text_abjad.visibility = View.VISIBLE
                text_abjad.text = data.alphabet
            } else {
                text_abjad.visibility = View.INVISIBLE
                text_abjad.text = data.text.substring(0, 1)
            }

            text_item.text = data.text
        }
    }
}