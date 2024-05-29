package com.example.issues.presentation.view.issuesList

import androidx.recyclerview.widget.DiffUtil
import com.example.issues.domain.Issue
import javax.inject.Inject


class MyDiffUtil @Inject constructor(
    private val oldList: List<Issue>,
    private val newList: List<Issue>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id == newList[newItemPosition].id -> false
            oldList[oldItemPosition].title == newList[newItemPosition].title -> false
            oldList[oldItemPosition].body == newList[newItemPosition].body -> false
            else -> true
        }
    }
}