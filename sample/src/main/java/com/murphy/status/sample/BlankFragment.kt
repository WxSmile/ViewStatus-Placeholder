package com.murphy.status.sample

import android.os.Bundle
import android.view.View
import com.murphy.status.placeholder.PlaceholderFragment
import com.murphy.status.placeholder.PlaceholderNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.common_fragment_blank_placeholder.*
import javax.inject.Inject

@AndroidEntryPoint
class BlankFragment @Inject constructor(): PlaceholderFragment() {

    @Inject lateinit var placeholderNavigation: PlaceholderNavigation

    override fun getPlaceholderLayout(): Int {
        return R.layout.common_fragment_blank_placeholder
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView.setOnClickListener {
            placeholderNavigation.removePlaceholder(requireActivity())
        }
    }
}