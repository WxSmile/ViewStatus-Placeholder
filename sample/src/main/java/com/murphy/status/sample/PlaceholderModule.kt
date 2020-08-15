package com.murphy.status.sample

import com.murphy.status.placeholder.Blank
import com.murphy.status.placeholder.Error
import com.murphy.status.placeholder.Loading
import com.murphy.status.placeholder.PlaceholderFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped


@Module
@InstallIn(ActivityComponent::class)
class PlaceholderModule {

    @Provides
    @ActivityScoped
    @Blank
    fun provideBlankPlaceholder(): PlaceholderFragment {
        return BlankFragment()
    }

    @Provides
    @ActivityScoped
    @Loading
    fun provideLoadingPlaceholder(): PlaceholderFragment {
        return LoadingFragment()
    }

    @Provides
    @ActivityScoped
    @Error
    fun provideErrorPlaceholder(): PlaceholderFragment {
        return ErrorFragment()
    }

}