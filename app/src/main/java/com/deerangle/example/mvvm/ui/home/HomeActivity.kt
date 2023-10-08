package com.deerangle.example.mvvm.ui.home

import androidx.activity.viewModels
import com.deerangle.example.mvvm.R
import com.deerangle.example.mvvm.databinding.ActivityHomeBinding
import com.deerangle.example.mvvm.utils.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(R.layout.activity_home) {
    override val viewModel: HomeViewModel by viewModels()

    override fun setupView() {
    }
}
