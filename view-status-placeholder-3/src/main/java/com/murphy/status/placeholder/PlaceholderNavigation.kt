package com.murphy.status.placeholder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.murphy.status.placeholder.Placeholder.*
import javax.inject.Inject
import javax.inject.Qualifier

class PlaceholderNavigation @Inject constructor() {

    @Inject
    @Blank
    lateinit var blankPlaceholder: PlaceholderFragment

    @Inject
    @Loading
    lateinit var loadingPlaceholder: PlaceholderFragment

    @Inject
    @Error
    lateinit var errorPlaceholder: PlaceholderFragment

    fun navigationPlaceholder(
        placeholderOwner: FragmentActivity,
        placeholder: PlaceholderFragment,
        id: Int = placeholderOwner.findViewById<View>(android.R.id.content).id
    ) {
        placeholderOwner.supportFragmentManager
            .beginTransaction()
            .replace(id, placeholder)
            .addToBackStack(placeholder.javaClass.name).commit()
    }

    fun navigationPlaceholder(
        placeholderOwner: FragmentActivity,
        placeholder: Placeholder,
        id: Int = placeholderOwner.findViewById<View>(android.R.id.content).id
    ) {
        val holder: PlaceholderFragment = when (placeholder) {
            BLANK -> { blankPlaceholder }
            LOADING -> { loadingPlaceholder }
            ERROR -> { errorPlaceholder }
        }
        placeholderOwner.supportFragmentManager
            .beginTransaction()
            .replace(id, holder)
            .addToBackStack(placeholder.name).commit()
    }

    fun removePlaceholder(placeholderOwner: FragmentActivity) {
        placeholderOwner.supportFragmentManager.popBackStack(null, 1)
    }
}

enum class Placeholder {
    BLANK,
    LOADING,
    ERROR
}

@Qualifier
annotation class Blank

@Qualifier
annotation class Loading

@Qualifier
annotation class Error

abstract class PlaceholderFragment : Fragment() {

    private var blankView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (blankView == null) {
            blankView = inflater.inflate(getPlaceholderLayout(), container, false)
        }
        return blankView
    }

    abstract fun getPlaceholderLayout(): Int
}




