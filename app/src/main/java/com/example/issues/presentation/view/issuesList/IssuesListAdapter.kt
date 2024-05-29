package com.example.issues.presentation.view.issuesList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.issues.R
import com.example.issues.domain.Issue

class IssuesListAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<IssuesListViewHolder>() {

    private var OldIssuesList = listOf<Issue>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssuesListViewHolder {
        return IssuesListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.issues_view_holder, parent, false)
        )
    }

    override fun getItemCount(): Int = OldIssuesList.size
    private fun getItem(position: Int) = OldIssuesList[position]

    override fun onBindViewHolder(holder: IssuesListViewHolder, position: Int) {
        holder.bindData(getItem(position))
        holder.itemView.setOnClickListener {
            clickListener.onCLick(getItem(position))
        }
    }

    fun bindIssue(newIssueList: List<Issue>) {
            val diffUtil = MyDiffUtil(OldIssuesList, newIssueList)
            val diffResults = DiffUtil.calculateDiff(diffUtil)
            OldIssuesList = newIssueList
            diffResults.dispatchUpdatesTo(this)
    }

    private fun areIssueIsIssue(issueList: List<Issue>): Boolean {
        issueList.forEach {
            return it.nodeId.contains("I")
        }
        return true
    }
}

class IssuesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val issueTitle = itemView.findViewById<TextView>(R.id.issue_title)
    private val issueBody = itemView.findViewById<TextView>(R.id.issue_body)

    fun bindData(issue: Issue) {
        issueTitle.text = issue.title
        issueBody.text = issue.body.toString()
    }
}