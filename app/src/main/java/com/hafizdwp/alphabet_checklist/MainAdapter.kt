package com.hafizdwp.alphabet_checklist

import android.view.View
import com.hafizdwp.alphabet_checklist.base.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.main_item.view.*

/**
 * @author hafizdwp
 * 29/06/2021
 **/
class MainAdapter : BaseRecyclerAdapter<Item>() {

    override val layoutRes: Int
        get() = R.layout.main_item
    override val listItem: List<Item>
        get() = arrayListOf(
                Item("A", "Aris"),
                Item("B", "Bailong"),
                Item("D", "Dellon"),
        )

    override fun onBind(itemView: View, data: Item, position: Int) {
        itemView.apply {
            text_abjad.text = data.alphabet
            text_item.text = data.text
        }
    }
}