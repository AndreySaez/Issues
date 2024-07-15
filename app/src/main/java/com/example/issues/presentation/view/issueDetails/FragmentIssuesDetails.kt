package com.example.issues.presentation.view.issueDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.issues.R
import com.example.issues.domain.Issue
import com.example.issues.presentation.view.navigation.Navigator

class FragmentIssuesDetails : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_issue_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            Navigator.closeDetails()
        }
        val issueData = arguments?.getParcelable(ISSUE_KEY) as? Issue
            ?: throw IllegalStateException("Иди нахуй")
        issueData?.let {
            bindData(it, view)
        }

    }

    private fun bindData(issue: Issue, view: View) {
        view.findViewById<TextView>(R.id.details_issue_title).apply {
            text = issue.title
        }
        view.findViewById<TextView>(R.id.details_issue_body).apply {
            text = issue.body
        }
    }


    companion object {

        private const val ISSUE_KEY = "Issue"
        fun newInstance(issue: Issue): FragmentIssuesDetails {
            return FragmentIssuesDetails().apply {
                arguments = bundleOf(ISSUE_KEY to issue)
            }
        }
    }
}