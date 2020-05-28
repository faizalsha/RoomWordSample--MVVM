package com.faizal.shadab.roomwordsample

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.RecyclerView

class MyCallBack(
    private val wordViewModel: WordViewModel,
    private val adapter: WordListAdapter
): ItemTouchHelper.SimpleCallback(
    0,
    RIGHT
) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        wordViewModel.delete(adapter.getWordAt(viewHolder.adapterPosition))
    }
}