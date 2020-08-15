package com.murphy.status.sample

import com.murphy.status.placeholder.PlaceholderFragment
import javax.inject.Inject

class NetErrorFragment @Inject constructor(): PlaceholderFragment() {

    override fun getPlaceholderLayout(): Int {
        return R.layout.common_fragment_net_error_placeholder
    }
}