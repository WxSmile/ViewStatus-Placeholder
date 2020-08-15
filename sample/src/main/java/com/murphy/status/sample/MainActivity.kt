package com.murphy.status.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.murphy.status.placeholder.Placeholder.LOADING
import com.murphy.status.placeholder.PlaceholderNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var placeholderNavigation: PlaceholderNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        placeholderNavigation.navigationPlaceholder(this, NetErrorFragment())
//        placeholderNavigation.navigationPlaceholder(this, LOADING)
        placeholderNavigation.navigationPlaceholder(this, LOADING, R.id.container)
    }
}