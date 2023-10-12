package com.deerangle.example.mvvm.di

import com.deerangle.example.mvvm.utils.helper.ResourceProvider
import com.deerangle.example.mvvm.utils.helper.ResourceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindModule {
    @Binds
    abstract fun bindResourceProvider(androidResourceProvider: ResourceProviderImpl): ResourceProvider
}
