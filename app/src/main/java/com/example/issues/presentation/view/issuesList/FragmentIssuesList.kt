package com.example.issues.presentation.view.issuesList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.issues.R
import com.example.issues.di.appComponent
import com.example.issues.presentation.ViewModelFactory
import com.example.issues.presentation.view.issueDetails.FragmentIssuesDetails
import com.example.issues.presentation.viewModel.IssuesViewModel
import dagger.Lazy
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class FragmentIssuesList : Fragment() {
    private var recycler: RecyclerView? = null
    private lateinit var adapter: IssuesListAdapter
    private lateinit var swipeView: SwipeRefreshLayout
    private val viewModel by viewModels<IssuesViewModel> { viewModelFactory.get() }

    @Inject
    lateinit var viewModelFactory: Lazy<ViewModelFactory>
    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_issues_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.rc_view)
        adapter = IssuesListAdapter {
            val issueDetails = FragmentIssuesDetails.newInstance(it)
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, issueDetails)
                .addToBackStack(null)
                .commit()
        }
        recycler?.adapter = adapter
        recycler?.layoutManager = LinearLayoutManager(context)
        //SWIPE VIEW
        swipeView = view.findViewById(R.id.swipe_to_refresh_view)

        viewModel.issuesList.onEach {
            adapter.bindIssue(it)
            swipeView.isRefreshing = false
            recycler?.post {
                recycler?.smoothScrollToPosition(0)
            }
        }.launchIn(lifecycleScope)
        refreshRecycler()
    }

    private fun refreshRecycler() {
        swipeView.setOnRefreshListener {
            viewModel.onRefresh()
        }
    }
}