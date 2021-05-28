package com.newsapp.ui.news.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.newsapp.R
import com.newsapp.databinding.NewsDetailsFragmentBinding
import com.newsapp.ui.news.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsDetails : Fragment(R.layout.news_details_fragment) {

    private lateinit var binding: NewsDetailsFragmentBinding

    private val viewModel by viewModels<NewsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = NewsDetailsFragmentBinding.bind(view)
    }
}