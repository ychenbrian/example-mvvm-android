package com.deerangle.example.mvvm.utils.base

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import com.deerangle.example.mvvm.utils.helper.NetworkHelper
import com.deerangle.example.mvvm.utils.helper.ResourceProvider
import com.deerangle.example.mvvm.utils.helper.ResourceProviderImpl
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
abstract class BaseTest {
    protected lateinit var networkHelper: NetworkHelper
    protected lateinit var resourceProvider: ResourceProvider

    @Mock
    protected lateinit var context: Context

    @Mock
    protected lateinit var resources: Resources

    @Mock
    protected lateinit var connectivityManager: ConnectivityManager

    @Mock
    protected lateinit var networkCapabilities: NetworkCapabilities

    @Mock
    protected lateinit var network: Network

    @Before
    open fun setup() {
        Mockito.`when`(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(connectivityManager)
        Mockito.`when`(connectivityManager.activeNetwork).thenReturn(network)
        Mockito.`when`(connectivityManager.getNetworkCapabilities(network)).thenReturn(networkCapabilities)
        networkHelper = NetworkHelper(context)

        Mockito.`when`(context.resources).thenReturn(resources)
        resourceProvider = ResourceProviderImpl(context)
    }
}
