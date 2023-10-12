package com.deerangle.example.mvvm.utils.helper

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.BoolRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

interface ResourceProvider {
    fun getString(
        resourceIdentifier: Int,
        vararg arguments: Any = arrayOf(),
    ): String

    fun getStringArray(resourceIdentifier: Int): Array<String>

    fun getInteger(resourceIdentifier: Int): Int

    fun getIntegerArray(resourceIdentifier: Int): Array<Int>

    fun getBoolean(resourceIdentifier: Int): Boolean
}

@Singleton
class ResourceProviderImpl
    @Inject
    constructor(
        @ApplicationContext private val context: Context,
    ) : ResourceProvider {
        override fun getString(
            @StringRes resourceIdentifier: Int,
            vararg arguments: Any,
        ): String {
            return if (arguments.isNotEmpty()) {
                context.resources.getString(resourceIdentifier, *arguments)
            } else {
                context.resources.getString(resourceIdentifier)
            }
        }

        override fun getStringArray(
            @ArrayRes resourceIdentifier: Int,
        ): Array<String> = context.resources.getStringArray(resourceIdentifier)

        override fun getInteger(
            @IntegerRes resourceIdentifier: Int,
        ): Int = context.resources.getInteger(resourceIdentifier)

        override fun getIntegerArray(
            @ArrayRes resourceIdentifier: Int,
        ): Array<Int> = context.resources.getIntArray(resourceIdentifier).toTypedArray()

        override fun getBoolean(
            @BoolRes resourceIdentifier: Int,
        ): Boolean = context.resources.getBoolean(resourceIdentifier)
    }

// interface ResourceProvider {
//    fun getString(@StringRes resId: Int): String
//    fun getColor(@ColorRes resId: Int): Int
//    // Add more methods as needed
// }
//
// // A default implementation that uses the application context
// class ResourceProviderImpl @Inject constructor(
//    @ApplicationContext private val context: Context
// ) : ResourceProvider {
//    override fun getString(resId: Int): String {
//        return context.getString(resId)
//    }
//
//    override fun getColor(resId: Int): Int {
//        return ContextCompat.getColor(context, resId)
//    }
// }