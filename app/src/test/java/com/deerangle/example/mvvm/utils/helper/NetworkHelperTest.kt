package com.deerangle.example.mvvm.utils.helper

import android.net.NetworkCapabilities
import com.deerangle.example.mvvm.utils.base.BaseTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NetworkHelperTest : BaseTest() {
    @Test
    fun testNetworkConnection_whenWifiIsConnected_returnTrue() {
        Mockito.`when`(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)).thenReturn(true)

        assert(networkHelper.isNetworkConnected())
    }
}
