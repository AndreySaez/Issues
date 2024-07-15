package com.example.issues

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.example.issues.domain.Issue
import com.example.issues.presentation.view.navigation.Navigator
import com.example.issues.presentation.view.issueDetails.FragmentIssuesDetails
import com.example.issues.presentation.view.issuesList.FragmentIssuesList
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private val detailsContainer by lazy {
        findViewById<FrameLayout>(R.id.details_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.list_fragment, FragmentIssuesList())
                .commit()
        }

        Navigator.state
            .onEach {
                if (it.details != null) {
                    navigationOnDetails(it.details)
                } else {
                    navigationWithoutDetails()
                }
            }
            .launchIn(lifecycleScope)
    }

    private fun navigationWithoutDetails() {
        detailsContainer.isInvisible = true
    }

    private fun navigationOnDetails(details: Issue) {
        detailsContainer.isInvisible = false
        val issueDetails = FragmentIssuesDetails.newInstance(details)
        supportFragmentManager.commit {
            replace(R.id.details_fragment, issueDetails)
        }
    }
}