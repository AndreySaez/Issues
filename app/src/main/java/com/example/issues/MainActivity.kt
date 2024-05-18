package com.example.issues

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.issues.presentation.view.issuesList.FragmentIssuesList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, FragmentIssuesList())
            .commit()
    }
}