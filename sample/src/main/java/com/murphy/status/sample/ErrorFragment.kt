package com.murphy.status.sample

import com.murphy.status.placeholder.PlaceholderFragment
import javax.inject.Inject

class ErrorFragment @Inject constructor(): PlaceholderFragment() {

    override fun getPlaceholderLayout(): Int {
        return R.layout.common_fragment_error_placeholder
    }
}