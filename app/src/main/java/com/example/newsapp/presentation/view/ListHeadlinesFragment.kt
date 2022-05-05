package com.example.newsapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.databinding.FragmentListHeadlinesBinding
import com.example.newsapp.domain.entity.ListHeadlinesEvent
import com.example.newsapp.presentation.adapter.HeadlineAdapter
import com.example.newsapp.presentation.viewmodel.ListHeadlinesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListHeadlinesFragment : Fragment() {

    private lateinit var binding: FragmentListHeadlinesBinding

    private val viewModel: ListHeadlinesViewModel by viewModel()
    private val adapter = HeadlineAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_headlines,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        observeUiEvent()
    }

    private fun observeUiEvent() {
        viewModel.getEvent().observe(viewLifecycleOwner) { event ->
            when (event) {
                is ListHeadlinesEvent.GetListNews -> setListNews(event.news)
            }
        }
    }

    private fun setListNews(news: NewsResponse) {
        adapter.setListNews(news.articles)
    }


    private fun setAdapter() {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.fragmentListHeadlinesRecyclerView.layoutManager = layoutManager
        binding.fragmentListHeadlinesRecyclerView.adapter = adapter
    }

}