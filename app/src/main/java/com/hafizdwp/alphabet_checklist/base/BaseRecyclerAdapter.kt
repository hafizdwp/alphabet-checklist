package com.hafizdwp.alphabet_checklist.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * @author hafizdwp
 * 29/06/2021
 **/
abstract class BaseRecyclerAdapter<MODEL> : RecyclerView.Adapter<BaseRecyclerAdapter<MODEL>.ViewHolder>() {


    @get:LayoutRes
    abstract val layoutRes: Int
    abstract val listItem: List<MODEL>

    abstract fun onBind(itemView: View, data: MODEL, position: Int)

    open fun onGetItemCount(): Int {
        return listItem.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItem[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return onGetItemCount()
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: MODEL) {
            onBind(view, data, adapterPosition)
        }
    }
}