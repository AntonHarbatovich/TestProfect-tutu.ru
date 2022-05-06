package com.example.newsapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.domain.entity.NewsEvent
import com.example.newsapp.presentation.viewmodel.NewsViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModel {
        parametersOf(arguments ?: Bundle())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_news,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUIEvent()
    }

    private fun observeUIEvent() {
        viewModel.getEvent().observe(viewLifecycleOwner) { event ->
            when (event) {
                is NewsEvent.SetArticle -> setFields(event.article)
            }
        }
    }

    private fun setFields(article: Article) {
        binding.fragmentNewsTitle.text = article.title
        if (article.author != null)
            binding.fragmentNewsAuthor.text = article.author
        binding.fragmentNewsTime.text = article.publishedAt
        binding.fragmentNewsDescription.text = article.description
        loadImage(article.urlToImage)
    }

    private fun loadImage(url: String?) {
        if (url != null) {
            Picasso.get().load(url).into(binding.fragmentNewsImage)
        }
    }
}