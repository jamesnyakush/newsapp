package com.newsapp.ui.news.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.newsapp.R
import com.newsapp.data.local.entity.Article
import com.newsapp.databinding.NewsFragmentBinding
import com.newsapp.ui.news.adapter.NewsAdapter
import com.newsapp.ui.news.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class News : Fragment(R.layout.news_fragment) {

    private lateinit var binding: NewsFragmentBinding

    private val viewModel by viewModels<NewsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = NewsFragmentBinding.bind(view)

        observeArticles()
    }

    /**
     *
     */
    private fun observeArticles() {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        observeOfflineArticles()
    }

    private fun observeOfflineArticles() {
        viewModel.fetchNewsFromLocal.observe(viewLifecycleOwner, Observer {
            setupRecyclerView(it)
        })
    }

    /**
     *
     */
    private fun setupRecyclerView(article: List<Article>) {
        binding.recyclerViewArticles.apply {
            layoutManager = LinearLayoutManager(requireContext())
            hasFixedSize()
            adapter = NewsAdapter(article)
        }
    }
}