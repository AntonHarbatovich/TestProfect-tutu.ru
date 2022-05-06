package com.example.newsapp.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newsapp.R
import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.domain.entity.NewsEvent
import com.example.newsapp.presentation.viewmodel.NewsViewModel
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
        binding.viewModel = viewModel
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
                is NewsEvent.BackClicked -> getBack()
            }
        }
    }

    private fun getBack() {
        Log.e("NewsFragment", "getBack")
        findNavController().popBackStack()
        viewModel.resetEvent()
    }

    private fun setFields(article: Article) {
        binding.article = article
        formatDate(article.publishedAt)
    }

    private fun formatDate(date: String) {
        val result = date.split("T")
        val newDate = "${result[0]} ${result[1].substring(0, result[1].lastIndexOf(":"))} "
        binding.fragmentNewsTime.text = newDate
    }
}
