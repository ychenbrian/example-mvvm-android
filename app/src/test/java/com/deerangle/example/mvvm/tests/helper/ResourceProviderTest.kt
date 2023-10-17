package com.deerangle.example.mvvm.tests.helper

import com.deerangle.example.mvvm.R
import com.deerangle.example.mvvm.base.BaseTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResourceProviderTest : BaseTest() {
    @Test
    fun getString_returnsCorrectValue() {
        val resId = R.string.no_internet_connection
        val value = "No internet connection"

        val result = resourceProvider.getString(resId)

        assertEquals(value, result)
    }
}
