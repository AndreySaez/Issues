package com.example.issues.presentation.view.issuesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.issues.R
import com.example.issues.presentation.view.issueDetails.FragmentIssuesDetails
import com.example.issues.presentation.viewModel.IssuesViewModel

class FragmentIssuesList : Fragment() {
    private var recycler: RecyclerView? = null
    private val viewModel by viewModels<IssuesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_issues_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.rc_view)
        val adapter = IssuesListAdapter {
            val issueDetails = FragmentIssuesDetails().apply {
                arguments = bundleOf("Issue" to it)
            }
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, issueDetails)
                .addToBackStack(null)
                .commit()
        }
        recycler?.adapter = adapter
        recycler?.layoutManager = LinearLayoutManager(context)
        viewModel.issuesList.observe(viewLifecycleOwner) {
            it ?: return@observe
            adapter.bindIssue(it)
        }
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? IssuesListAdapter)?.apply {
        }
    }
}