package com.example.annamihaleva.notestask.ui.adapter

import android.support.v7.widget.RecyclerView
import com.example.annamihaleva.notestask.ui.adapter.holder.BaseHolder

abstract class BaseAdapter<T>(private val bind: (viewHolder: BaseHolder, pos: Int, item: T) -> Unit)
    : RecyclerView.Adapter<BaseHolder>() {

    private var items = mutableListOf<T>()

    override fun onBindViewHolder(viewHolder: BaseHolder, pos: Int) {
        bind.invoke(viewHolder, pos, items[pos])
    }

    fun add(item: T, index: Int) {
        items.add(index, item)
        notifyItemInserted(index)
    }

    fun addAll(newItems: List<T>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun remove(item: T) {
        val pos = items.indexOfFirst { it == item }
        items.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun update(item: T) {
        val pos = items.indexOfFirst { it == item }
        notifyItemChanged(pos)
    }

    fun getSize() = items.size

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    fun getItem(index: Int) : T? =
            items[index]
}
