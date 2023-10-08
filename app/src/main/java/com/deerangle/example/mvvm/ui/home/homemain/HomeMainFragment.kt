package com.deerangle.example.mvvm.ui.home.homemain

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.deerangle.example.mvvm.R
import com.deerangle.example.mvvm.data.model.domain.Book
import com.deerangle.example.mvvm.databinding.FragmentHomeMainBinding
import com.deerangle.example.mvvm.utils.base.BaseFragment
import com.deerangle.example.mvvm.utils.core.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeMainFragment : BaseFragment<FragmentHomeMainBinding, HomeMainViewModel>(R.layout.fragment_home_main) {
    override val viewModel: HomeMainViewModel by viewModels()

    private val controller by lazy {
        HomeMainController()
    }

    override fun setupView() {
        binding.frHomeMainErv.apply {
            adapter = controller.adapter
        }

        setupObserver()

        viewModel.fetchBooks()
    }

    private fun setupObserver() {
        viewModel.books.observe(
            this,
            Observer {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { books -> renderList(books) }
                    }
                    Status.LOADING -> {
                    }
                    Status.ERROR -> {
                        // Handle Error
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            },
        )
    }

    private fun renderList(books: List<Book>) {
        controller.setData(books)
    }
}
