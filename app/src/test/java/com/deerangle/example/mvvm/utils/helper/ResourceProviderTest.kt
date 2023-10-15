package com.deerangle.example.mvvm.utils.helper

import android.content.Context
import android.content.res.Resources
import com.deerangle.example.mvvm.R
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResourceProviderTest {
    private lateinit var resourceProvider: ResourceProvider

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var resources: Resources

    @Before
    fun setUp() {
        resourceProvider = ResourceProviderImpl(context)
        Mockito.`when`(context.resources).thenReturn(resources)
    }

    @Test
    fun getString_returnsCorrectValue() {
        val resId = R.string.no_internet_connection
        val value = "No internet connection"

        Mockito.`when`(resources.getString(resId)).thenReturn(value)
        val result = resourceProvider.getString(resId)

        assertEquals(value, result)
    }
}
